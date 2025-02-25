package com.sky.mapper;

import com.sky.entity.AddressBook;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {
    List<AddressBook> selectAll(AddressBook addressBook);
    @Insert("insert into address_book(user_id, consignee, sex, phone, province_code, province_name, city_code, city_name, district_code, district_name, detail, label, is_default) " +
            " values(#{userId},#{consignee},#{sex},#{phone},#{provinceCode},#{provinceName},#{cityCode},#{cityName},#{districtCode},#{districtName},#{detail},#{label},#{isDefault})")
    void add(AddressBook addressBook);
    @Delete("delete from address_book where id=#{id}")
    void delete(Long id);
    @Select("select * from address_book where id=#{id}")
    AddressBook selectById(Long id);
    @Update("update address_book set is_default=1 where id=#{id}")
    void beDefault(AddressBook addressBook);
    @Update("update address_book set is_default=0 where user_id=#{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);
}
