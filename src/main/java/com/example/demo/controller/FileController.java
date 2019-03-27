package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.utils.FileUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传下载
 *
 * @author liuchen25
 * @description
 * @time 2018/11/2 16:04
 */
@RestController
@RequestMapping("file")
public class FileController {

    @ApiOperation("文件上传")
    @PostMapping(value = "upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public Result<String> uploadFile(@ApiParam(value = "上传文件", required = true) MultipartFile file) {

        String result = FileUtils.uploadFile(file);
        Result<String> ok = Result.ok();
        ok.setResult(result);
        return ok;
    }

    @ApiOperation("文件下载")
    @RequestMapping(value = "download", method = RequestMethod.GET)
    public Result<String> download(@RequestParam(value = "下传文件") String fileId, HttpServletResponse response) {

        FileUtils.downloadFile(fileId, response);
        return Result.ok();
    }

    @ApiOperation("测试")
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Result<String> test() {
        System.out.println("test success");
        return Result.ok("sdfjalskdfjalsdkfj");
    }

}
