/**
 * Bilibili.com Inc.
 * Copyright (c) 2009-2018 All Rights Reserved.
 */
package sun.juwin.makers.baseproject.model;

import com.google.common.base.Strings;
import sun.juwin.exception.BaseCodeMakerException;
import sun.juwin.makers.baseproject.database.JdbcModel;

/**
 * @author sunqinwen
 * @version \: CodePath.java,v 0.1 2018-08-07 18:19
 */
public class BaseCodePath {

    private String tableName;

    private String className;

    // 惯用类格式路径
    private String baseProPath;

    private String pointModelPath;

    private String pointMapperPath;

    private String pointServicePath;

    private String pointServiceImplPath;

    private String pointControllerPath;

    // 文件绝对路径
    private String targetModelPath;

    private String targetMapperPath;

    private String targetServicePath;

    private String targetServiceImplPath;

    private String targetControllerPath;

    public boolean check() {
        return Strings.isNullOrEmpty(tableName) ||
                Strings.isNullOrEmpty(className) ||
                Strings.isNullOrEmpty(baseProPath);
    }

    public BaseCodePath(String mysqlUrl, String mysqlUser, String mysqlPwd, String schema) throws BaseCodeMakerException {
        if (Strings.isNullOrEmpty(mysqlUrl)
                || Strings.isNullOrEmpty(mysqlUser)
                || Strings.isNullOrEmpty(mysqlPwd)
                || Strings.isNullOrEmpty(schema)) {
            throw new BaseCodeMakerException("mysql 4 params can not be null!");
        }
        JdbcModel.url = mysqlUrl;
        JdbcModel.user = mysqlUser;
        JdbcModel.pwd = mysqlPwd;
        JdbcModel.schema = schema;
    }

    public String getBaseProPath() {
        return baseProPath;
    }

    public BaseCodePath setBaseProPath(String baseProPath) {
        this.baseProPath = baseProPath;
        return this;
    }

    public String getPointModelPath() {
        return pointModelPath;
    }

    public BaseCodePath setPointModelPath(String pointModelPath) {
        this.pointModelPath = pointModelPath;
        if(!Strings.isNullOrEmpty(pointModelPath)){
            targetModelPath = String.format("%s/%s", baseProPath, pointModelPath.replace(".", "/"));
        }
        return this;
    }

    public String getPointMapperPath() {
        return pointMapperPath;
    }

    public BaseCodePath setPointMapperPath(String pointMapperPath) {
        this.pointMapperPath = pointMapperPath;
        if(!Strings.isNullOrEmpty(pointMapperPath)){
            targetMapperPath = String.format("%s/%s", baseProPath, pointMapperPath.replace(".", "/"));
        }
        return this;
    }

    public String getPointServicePath() {
        return pointServicePath;
    }

    public BaseCodePath setPointServicePath(String pointServicePath) {
        this.pointServicePath = pointServicePath;
        if(!Strings.isNullOrEmpty(pointServicePath)){
            targetServicePath = String.format("%s/%s", baseProPath, pointServicePath.replace(".", "/"));
        }
        return this;
    }

    public String getPointServiceImplPath() {
        return pointServiceImplPath;
    }

    public BaseCodePath setPointServiceImplPath(String pointServiceImplPath) {
        this.pointServiceImplPath = pointServiceImplPath;
        if(!Strings.isNullOrEmpty(pointServiceImplPath)){
            targetServiceImplPath = String.format("%s/%s", baseProPath, pointServiceImplPath.replace(".", "/"));
        }
        return this;
    }

    public String getPointControllerPath() {
        return pointControllerPath;
    }

    public BaseCodePath setPointControllerPath(String pointControllerPath) {
        this.pointControllerPath = pointControllerPath;
        if(!Strings.isNullOrEmpty(pointControllerPath)){
            targetControllerPath = String.format("%s/%s", baseProPath, pointControllerPath.replace(".", "/"));
        }
        return this;
    }

    public String getTargetModelPath() {
        return targetModelPath;
    }

    public String getTargetMapperPath() {
        return targetMapperPath;
    }

    public String getTargetServicePath() {
        return targetServicePath;
    }

    public String getTargetServiceImplPath() {
        return targetServiceImplPath;
    }

    public String getTargetControllerPath() {
        return targetControllerPath;
    }

    public String getTargetModelName() {
        return String.format("%s.java", className);
    }

    public String getTargetMapperName() {
        return String.format("%sMapper.java", className);
    }

    public String getTargetXmlName() {
        return String.format("%sMapper.xml", className);
    }

    public String getTargetServiceName() {
        return String.format("%sService.java", className);
    }

    public String getTargetServiceImplName() {
        return String.format("%sServiceImpl.java", className);
    }

    public String getTargetControllerName() {
        return String.format("%sController.java", className);
    }

    public String getTableName() {
        return tableName;
    }

    public BaseCodePath setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public BaseCodePath setClassName(String className) {
        this.className = className;
        return this;
    }
}
