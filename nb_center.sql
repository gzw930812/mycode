--现存车辆查询SQL
update t_qry_sql t set t.para_cnt = '4',t.para_desc = '车辆号牌||车架号||车种||车辆所属区域',t.para_val = 'P1||P2||P3||P4'
,t.sqls = 'with d as(   select distinct car_id,next_check_date from ( select a.id,a.car_id,
                 b.next_check_date,
                 rank() over(partition by a.car_id order by b.next_check_date desc) as xh
            from cnt_car_bottle_ref a
            left join cnt_bottle b
              on a.bottle_id = b.id
              where a.is_effective = 0) where xh = 1 )
              ,
     f as (   select distinct car_id,relation_date from ( select a.id,a.car_id,
                 a.relation_date,
                 rank() over(partition by a.car_id order by a.relation_date desc) as xh
            from cnt_car_bottle_ref a
              where a.is_effective = 0) where xh = 1
              )
select_last rownum as ^序号^,temp.* from (select a.car_plate_number ,
       a.id ,
       a.plate_color,
       a.car_frame_number,
       a.add_bottle_count,
       a.filling_medium,
       c.name as filling_property_name,
       b.name as car_type_name,
       a.car_master_type,
       a.car_maste_name,
       d.next_check_date,
       a.register_mode,
       to_date(to_char(a.create_date, |YYYY - MM - DD HH24 :MI :SS|),
               |YYYY - MM - DD HH24 :MI :SS|) as create_date,
       to_date(to_char(f.relation_date, |YYYY - MM - DD HH24 :MI :SS|),
              |YYYY - MM - DD HH24 :MI :SS|) as relation_date,
       a.car_status,
       rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc) ra
  from (select t.* from (
  select car.*,
  rank() over(partition by car.car_plate_number,car.plate_color order by car.create_date desc ) ra from cnt_car car ) 
  t where t.ra = 1) a
  left join cnt_car_type b on a.car_type_id = b.id
  left join cnt_filling_property c on a.filling_property_id = c.id
  left join d on a.id = d.car_id
  left join f on a.id = f.car_id
  left join sys_area j on a.area_id = j.id
  where a.car_status in (|7|,|8|,|9|,|A|) and nvl(a.cancel_status,|0|) = |0| and nvl(a.transfer_type,|0|) != |2|
  and a.del_flag = |0|
  and upper(a.car_plate_number) like upper(|%P1%|) and a.car_frame_number like |%P2%|
  and a.filling_property_id like |%P3%|
  and (nvl(j.parent_ids,|0|) like |%P4,%| or nvl(a.area_id,|0|) like |%P4%|)
  order by a.create_date )temp' where t.ordr_num = '1.1';
--现存车辆区域统计SQL  
update t_qry_sql t set t.sqls = 'with d as(select distinct car_id,next_check_date from ( select a.id,a.car_id,
                 b.next_check_date,
                 rank() over(partition by a.car_id order by b.next_check_date desc) as xh
            from cnt_car_bottle_ref a
            left join cnt_bottle b
              on a.bottle_id = b.id
              where a.is_effective = 0) where xh = 1 )
              ,
     f as (   select distinct car_id,relation_date from ( select a.id,a.car_id,
                 a.relation_date,
                 rank() over(partition by a.car_id order by a.relation_date desc) as xh
            from cnt_car_bottle_ref a
              where a.is_effective = 0) where xh = 1
              )
select nvl(decode(grouping(s.name), 1, |合计|, s.name),| |) as ^areaName^, 
       count(1) as ^count^
        from  ( select t.* from (
                  select a.*,
                  rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc ) ra 
                  from cnt_car a 
                  left join cnt_car_type b on a.car_type_id = b.id
                  left join cnt_filling_property c on a.filling_property_id = c.id
                  left join d on a.id = d.car_id
                  left join f on a.id = f.car_id
                ) t where t.ra = 1) g
        left join sys_area s
        on g.area_id = s.id
        where g.car_status in (|7|,|8|,|9|,|A|)
            and nvl(g.cancel_status,|0|) = |0|
            and nvl(g.transfer_type,|0|) != |2|
            and g.create_date >= to_timestamp(|P1|,|yyyy-mm-dd hh24:mi:ss|) 
            and g.create_date <= to_timestamp(|P2|,|yyyy-mm-dd hh24:mi:ss|)
            and g.del_flag = |0|
       group by rollup(s.name)' where t.ordr_num = '1.1.1.5';
--现存车辆充装介质统计SQL
delete t_qry_sql where ordr_num = '1.1.1.7';	   
insert into t_qry_sql(ordr_num,ctgy,nm,hrcy_nm,para_cnt,para_desc,para_val,is_page,sqls)
values('1.1.1.7','统计报表','按车辆充装介质统计','统计报表\现存车辆信息查询\按车辆充装介质统计',2,'车辆登记开始日期||车辆登记结束日期','P1||P2',0,'with d as(select distinct car_id,next_check_date from ( select a.id,a.car_id,
                 b.next_check_date,
                 rank() over(partition by a.car_id order by b.next_check_date desc) as xh
            from cnt_car_bottle_ref a
            left join cnt_bottle b
              on a.bottle_id = b.id
              where a.is_effective = 0) where xh = 1 )
              ,
     f as (   select distinct car_id,relation_date from ( select a.id,a.car_id,
                 a.relation_date,
                 rank() over(partition by a.car_id order by a.relation_date desc) as xh
            from cnt_car_bottle_ref a
              where a.is_effective = 0) where xh = 1
              )
select decode(grouping(sd.label), 1, |合计|, sd.label) as ^fillingMedium^, 
       count(1) as ^count^
        from  ( select t.* from (
                  select a.*,
                  rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc ) ra 
                  from cnt_car a 
                  left join cnt_car_type b on a.car_type_id = b.id
                  left join cnt_filling_property c on a.filling_property_id = c.id
                  left join d on a.id = d.car_id
                  left join f on a.id = f.car_id
                  left join sys_area s on a.area_id = s.id
                ) t where t.ra = 1) g
                left join sys_dict sd on sd.type = |fillingMedium| and sd.value = g.filling_medium
        where g.car_status in (|7|,|8|,|9|,|A|)
            and nvl(g.cancel_status,|0|) = |0|
            and nvl(g.transfer_type,|0|) != |2|
            and g.create_date >= to_timestamp(|P1|,|yyyy-mm-dd hh24:mi:ss|) 
            and g.create_date <= to_timestamp(|P2|,|yyyy-mm-dd hh24:mi:ss|)
            and g.del_flag = |0|
            group by rollup(sd.label)
');
--过户车辆查询SQL
update t_qry_sql t set t.sqls = 'select_last rownum as ^序号^,temp.* from (select
        h.* from (select distinct a.car_plate_number,
       a.plate_color ,
       a.car_frame_number ,
       a.add_bottle_count,
       a.filling_medium ,
       b.name as filling_property_name,
       i.name as car_type_name,
       a.car_master_type,
       a.car_maste_name ,
       d.next_check_date,
       a.register_mode,
       to_date(to_char(a.create_date,|YYYY-MM-DD HH24:MI:SS|),|YYYY-MM-DD HH24:MI:SS|) as create_date,
       to_date(to_char(c.relation_date,|YYYY-MM-DD HH24:MI:SS|),|YYYY-MM-DD HH24:MI:SS|) as relation_date,
       a.transfer_type,
       a.emigration_address_id,
       a.area_id,
       a.car_status
  from (select t.* from (
  select a0.*,
  rank() over(partition by a0.car_plate_number,a0.plate_color order by a0.create_date desc ) ra from (select * from cnt_car  where REGISTER_MODE = |2|  and transfer_type != |2|) a0 
) t where t.ra = 1) a
  left join cnt_filling_property b
    on a.filling_property_id = b.id
  left join cnt_car_type i
  on a.car_type_id = i.id
  left join cnt_tag_car_ref c
    on c.car_id = a.id and c.is_effective = |0|
  left join (select  g.id,
                           f.next_check_date,
                           rank() over(partition by g.id order by f.next_check_date desc) as xh
                      from cnt_car g
                      left join cnt_car_bottle_ref e on g.id = e.car_id and g.REGISTER_MODE = |2|
                      left join cnt_bottle f
                        on e.bottle_id = f.id and e.is_effective = |0|) d
            on a.id = d.id
         where xh = 1 and a.car_status in(|7|,|8|,|9|,|A|)
  and upper(a.car_plate_number) like upper(|%P1%|) and a.car_frame_number like |%P2%|
and a.filling_property_id like |%P3%| and a.transfer_type like |%P4%| and a.car_maste_name like |%P5%|
) h order by h.create_date ) temp' where t.ordr_num = '1.1.2';
--注销报废车辆查询SQL
update t_qry_sql t set t.para_cnt = 5,t.para_desc = '车辆号牌||车架号||车种||登记证状态||注销原因',t.para_val='P1||P2||P3||P4||P5',
t.sqls = ' select_last rownum as ^序号^,temp.* from (select  distinct b.id as ^id^, b.CAR_PLATE_NUMBER as ^carPlateNumber^,
 k.label as ^plateColor^,
 e.CREATE_DATE as ^createDate^,
 i.name as ^scrapReason^,
 b.ADD_BOTTLE_COUNT as ^bottleCount^,
 b.CAR_FRAME_NUMBER as ^frameNumber^,
 j.label as ^fillingMedium^,
 g.name as ^carType^,
 h.name as ^fillingProperty^,
 b.CAR_MASTE_NAME as ^masteName^
 from (select t.* from (
  select a.*,
  rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc ) ra from (select * from cnt_car where cancel_status != |0|) a 
) t where t.ra = 1) b
 left join cnt_car_registration_ref c
 on b.id = c.car_id
 left join cnt_bottle_registration d
 on c.registration_id = d.id
 left join cnt_car_scrap_reason e
 on e.car_id = b.id
 left join cnt_scrap_reason_type i
 on i.code = e.scrap_reason
 left join sys_area f
 on b.area_id = f.id
 left join cnt_car_type g
 on g.id = b.CAR_TYPE_ID
 left join cnt_filling_property h
 on h.id = b.FILLING_PROPERTY_ID
 left join sys_dict k
 on k.type=|plateColor| and k.value=b.PLATE_COLOR
 left join sys_dict j
 on j.type =|fillingMedium| and j.value=d.FILLING_MEDIUM
 where 1=1
 and b.car_status in (|7|,|8|,|9|,|A|)
 and upper(b.CAR_PLATE_NUMBER) like upper(|%P1%|)
 and b.CAR_FRAME_NUMBER like |%P2%|
 --车种
 and b.FILLING_PROPERTY_ID like |%P3%|
 and d.REGISTRATION_STATUS like |%P4%|
 and e.SCRAP_REASON like |%P5%| ) temp' 
 where t.ordr_num = '1.1.3';
--注销报废车辆区域统计SQL 
update t_qry_sql t set
t.sqls = 'select nvl(decode(grouping(c.name), 1, |合计|, c.name),| |) as ^areaName^, 
sum(1) as ^count^
  from  (select t.* from (
  select a.*,
  rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc ) ra from (select * from cnt_car where 
  cancel_status != |0|) a ) t where t.ra = 1) b
  left join sys_area c
    on b.area_id = c.id
  left join cnt_car_scrap_reason d 
    on d.car_id = b.id
 where 1 = 1
      and b.car_status in (|7|,|8|,|9|,|A|)
      and d.update_date >= to_timestamp(|P1|,|yyyy-mm-dd hh24:mi:ss|) 
      and d.update_date < to_timestamp(|P2|,|yyyy-mm-dd hh24:mi:ss|)
 group by rollup(c.name)' 
 where t.ordr_num = '1.1.3.2';
--注销报废车辆充装介质统计SQL 
delete t_qry_sql where ordr_num = '1.1.3.4';	   
insert into t_qry_sql(ordr_num,ctgy,nm,hrcy_nm,para_cnt,para_desc,para_val,is_page,sqls) 
values('1.1.3.4','统计报表','按车辆充装介质统计','统计报表\注销报废车辆查询\统计\按车辆充装介质统计',2,'车辆登记开始日期||车辆登记结束日期','P1||P2',0,
'select decode(grouping(c.label), 1, |合计|, c.label) as ^fillingMedium^, 
       count(1) as ^count^
  from  (select t.* from (
  select a.*,
  rank() over(partition by a.car_plate_number,a.plate_color order by a.create_date desc ) ra from (select * from cnt_car where 
  cancel_status != |0|) a ) t where t.ra = 1) b
  left join sys_dict c 
  on c.type = |fillingMedium| and c.value = b.filling_medium
  left join cnt_car_scrap_reason d 
    on d.car_id = b.id
 where 1 = 1
      and b.car_status in (|7|,|8|,|9|,|A|)
      and d.update_date >= to_timestamp(|P1|,|yyyy-mm-dd hh24:mi:ss|) 
      and d.update_date < to_timestamp(|P2|,|yyyy-mm-dd hh24:mi:ss|)
 group by rollup(c.label)
      ');
commit;	  
