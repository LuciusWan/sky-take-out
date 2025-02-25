package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.result.Result;
import com.sky.service.AddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/addressBook")
@Slf4j
@Api(tags = "地址簿相关接口")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;
    @GetMapping("/list")
    @ApiOperation("查询所有相关地址")
    public Result<List<AddressBook>> list() {
        log.info("查询用户所有地址");
        AddressBook addressBook = new AddressBook();
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.selectAll(addressBook);
        return Result.success(list);
    }
    @PostMapping
    @ApiOperation("新增地址")
    public Result add(@RequestBody AddressBook addressBook) {
        log.info("新增地址{}", addressBook);
        addressBookService.add(addressBook);
        return Result.success();
    }
    @DeleteMapping
    @ApiOperation("删除所选地址")
    public Result delete(@RequestParam Long id) {
        log.info("删除Id为{}的用户",id);
        addressBookService.delete(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result get(@PathVariable Long id) {
        log.info("查询id为{}的地址信息",id);
        return Result.success(addressBookService.selectById(id));
    }
    @PutMapping
    @ApiOperation("修改地址")
    public Result update(@RequestBody AddressBook addressBook) {
        log.info("修改客户的地址{}", addressBook);
        addressBookService.update(addressBook);
        return Result.success();
    }
    @PutMapping("/default")
    @ApiOperation("修改默认地址")
    public Result updateDefault(@RequestBody AddressBook addressBook) {
        log.info("修改addressBook为{}的地址为默认地址",addressBook);
        addressBookService.changeDefault(addressBook);
        return Result.success();
    }
    @GetMapping("/default")
    @ApiOperation("查询默认地址")
    public Result<AddressBook> getDefault() {
        log.info("查询默认地址");
        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = new AddressBook();
        addressBook.setIsDefault(1);
        addressBook.setUserId(BaseContext.getCurrentId());
        List<AddressBook> list = addressBookService.selectAll(addressBook);

        if (list != null && list.size() == 1) {
            return Result.success(list.get(0));
        }
        return Result.error("未查询到默认地址，请先设置默认地址");
    }
}
