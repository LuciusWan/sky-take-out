package com.sky.controller.admin;
import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.mapper.EmployeeMapper;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "员工接口测试")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @ApiOperation("员工登录")
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        //log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO =new  EmployeeLoginVO();
                employeeLoginVO.setToken(token);
                employeeLoginVO.setId(employee.getId());
                employeeLoginVO.setName(employee.getName());
                employeeLoginVO.setUserName(employee.getUsername());
        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @ApiOperation("员工登出")
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }
    @ApiOperation("员工添加")
    @PostMapping
    public Result save(@RequestBody EmployeeDTO employeeDTO) {
        //log.info("新增员工{}", employeeDTO);
        employeeService.Insert(employeeDTO);
        return Result.success();
    }
    @ApiOperation("分页查询员工")
    @GetMapping("/page")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO) {
        //log.info("分页查询员工,查询员工第{}页，每页有{}人", employeePageQueryDTO.getPage(), employeePageQueryDTO.getPageSize());
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }
    @ApiOperation("员工状态信息查询")
    @PostMapping("/status/{status}")
    public Result startOrStop(@PathVariable Integer status,Long id) {
        //log.info("启用和禁用员工账号");
        employeeService.startOrStop(status,id);
        return Result.success();
    }
    @ApiOperation("修改员工第一步")
    @GetMapping("/{id}")
    public Result<EmployeeDTO> selectById(@PathVariable Integer id) {
        EmployeeDTO employeeDTO=employeeService.select(id);
        return Result.success(employeeDTO);
    }
    @ApiOperation("修改员工第二步")
    @PutMapping()
    public Result update(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
        return Result.success();
    }
}
