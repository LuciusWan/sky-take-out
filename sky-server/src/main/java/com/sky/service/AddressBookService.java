package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

public interface AddressBookService {
    public List<AddressBook> selectAll(AddressBook addressBook);

    void add(AddressBook addressBook);

    void delete(Long id);

    AddressBook selectById(Long id);

    void update(AddressBook addressBook);

    void changeDefault(AddressBook addressBook);

}
