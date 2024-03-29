package practice.demo;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jay Yang
 * @date 2022/12/31
 */
public class RedPacketDemo {

    public static void main(String[] args) {

        int totalAmount = 8610;
        int packets = 20;

        Map<Integer, Long> doubleAverageStatistics = new TreeMap<>(Integer::compareTo);
        Map<Integer, Long> segmentCutStatistics = new TreeMap<>(Integer::compareTo);
        int rounds = 20000;

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            AbstractRedPacket doubleAverageRedPacket = new DoubleAverageRedPacket(totalAmount, packets);
            for (int j = 0; j < packets; j++) {
                int doubleAverageRedPacketAmount = doubleAverageRedPacket.open();
                Long doubleAverageTotalAmount = doubleAverageStatistics.get(j);
                doubleAverageTotalAmount = doubleAverageTotalAmount == null ? doubleAverageRedPacketAmount : (doubleAverageTotalAmount + doubleAverageRedPacketAmount);
                doubleAverageStatistics.put(j, doubleAverageTotalAmount);
            }
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            AbstractRedPacket segmentCutRedPacket = new SegmentCutRedPacket(totalAmount, packets);
            for (int j = 0; j < packets; j++) {
                int segmentCutRedPacketAmount = segmentCutRedPacket.open();
                Long segmentCutTotalAmount = segmentCutStatistics.get(j);
                segmentCutTotalAmount = segmentCutTotalAmount == null ? segmentCutRedPacketAmount : (segmentCutTotalAmount + segmentCutRedPacketAmount);
                segmentCutStatistics.put(j, segmentCutTotalAmount);
            }
        }
        long end2 = System.currentTimeMillis();

        for (int i = 0; i < packets; i++) {
            Long doubleAverageAmount = doubleAverageStatistics.get(i);
            Long segmentCutAmount = segmentCutStatistics.get(i);
            System.out.println(i + "\tdoubleAverage:\t" + doubleAverageAmount + "\tsegmentCut:\t" + segmentCutAmount);
        }

        System.out.println(end1 - start1);
        System.out.println(end2 - start2);

    }

    private static abstract class AbstractRedPacket {

        protected static final int MIN_AMOUNT = 2;
        protected static final Random RANDOM = ThreadLocalRandom.current();

        protected final int totalAmount;
        protected final int packets;
        protected int leftPackets;
        protected int leftAmount;

        public AbstractRedPacket(int totalAmount, int packets) {
            this.totalAmount = totalAmount;
            this.packets = packets;
            this.leftAmount = totalAmount;
            this.leftPackets = packets;
        }

        public int open() {
            if (openFinished()) {
                throw new IllegalStateException("红包没有了");
            }

            int amount = openRedPacket();

            leftPackets--;
            leftAmount -= amount;

            return amount;
        }

        /**
         * open red packet
         *
         * @return amount
         */
        protected abstract int openRedPacket();

        public boolean openFinished() {
            return leftPackets <= 0;
        }

    }

    private static class DoubleAverageRedPacket extends AbstractRedPacket {

        public DoubleAverageRedPacket(int totalAmount, int packets) {
            super(totalAmount, packets);
        }

        @Override
        public int openRedPacket() {

            if (leftPackets == 1) {
                return leftAmount;
            }

            int maxAmount = leftAmount / leftPackets * 2;
            return MIN_AMOUNT + RANDOM.nextInt(maxAmount);

        }

    }

    private static class SegmentCutRedPacket extends AbstractRedPacket {

        private final int[] indices;

        public SegmentCutRedPacket(int totalAmount, int packets) {
            super(totalAmount, packets);
            this.indices = this.initIndices();
        }

        private int[] initIndices() {
            int totalAmount = super.totalAmount - (MIN_AMOUNT * packets);
            int[] indices = new int[packets - 1];
            for (int i = 0; i < packets - 1; i++) {
                indices[i] = RANDOM.nextInt(totalAmount + 1);
            }
            Arrays.sort(indices);
            return indices;
        }

        @Override
        public int openRedPacket() {
            if (leftPackets <= 1) {
                return leftAmount;
            }
            if (leftPackets == packets) {
                return super.totalAmount - (MIN_AMOUNT * packets) - indices[packets - 2] + MIN_AMOUNT;
            }
            return indices[leftPackets - 1] - indices[leftPackets - 2] + MIN_AMOUNT;
        }

    }

}
