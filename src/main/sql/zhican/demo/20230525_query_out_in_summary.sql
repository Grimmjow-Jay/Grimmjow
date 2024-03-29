select owner_name           as '主体',
       period_date          as '期间',
       warehouse_name       as '仓库',
       sku_code             as 'SKU编码',
       null                 as 't+编码',
       sku_name             as 'SKU名称',
       specification        as '规格型号',
       unit_name            as '成本单位',
       before_cost_quantity as '期初数量',
       before_cost_price    as '期初单价',
       before_amount        as '期初金额',
       in_quantity          as '本期入库数量',
       in_price             as '本期入库单价',
       in_amount            as '本期入库金额',
       out_quantity         as '本期出库数量',
       out_price            as '本期出库单价',
       out_amount           as '本期出库金额',
       balance_quantity     as '结存数量',
       balance_price        as '结存单价',
       balance_amount       as '结存金额'
from zc_finance.out_in_summary
order by created_at desc, id desc;
