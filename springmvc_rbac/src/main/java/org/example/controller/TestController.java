package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.common.ApplicationContextHelper;
import org.example.common.JsonData;
import org.example.dao.SysAclModuleMapper;
import org.example.exception.BusinesException;
import org.example.exception.ParamException;
import org.example.model.SysAclModule;
import org.example.param.TestVo;
import org.example.util.BeanValidator;
import org.example.util.JsonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new BusinesException("test exception");
        // return JsonData.success("hello, permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
