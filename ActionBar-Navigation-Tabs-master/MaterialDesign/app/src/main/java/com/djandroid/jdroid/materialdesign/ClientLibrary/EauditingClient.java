package com.djandroid.jdroid.materialdesign.ClientLibrary;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpStatus;

import java.util.List;

import com.djandroid.jdroid.materialdesign.ClientLibrary.Common.EAuditingHttpResponse;
import com.djandroid.jdroid.materialdesign.ClientLibrary.Common.HttpWrapper;
import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.AndroidTaskService.GetTaskListRequest;
import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.AndroidTaskService.GetTaskListResponse;
import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.AndroidTaskService.TaskDetailResponse;
import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.AndroidTaskService.TaskInformation;
import com.djandroid.jdroid.materialdesign.ClientLibrary.HttpModel.UserService.*;
import com.djandroid.jdroid.materialdesign.ClientLibrary.Parameter.AuditStatus;


/**
 * Created by Jimmy on 2016/10/25.
 */
public class EauditingClient {

    public static Gson gson = new Gson();

    public static UserLoginResponse UserLogin(String userName, String password)
    {
        UserLoginResponse errorResponse = new UserLoginResponse();
        errorResponse.setStatus(UserLoginStatus.NetWorkError);

        try {
            UserLoginRequest request = new UserLoginRequest();
            request.setUsername(userName);
            request.setPasswordHash(HttpWrapper.SHA256(password));

            String requestEntity = gson.toJson(request);

            EAuditingHttpResponse userLoginResponse = HttpWrapper.HttpPost("/user/login", requestEntity);

            if (userLoginResponse.httpStatus != HttpStatus.SC_OK) return errorResponse;
            return gson.fromJson(userLoginResponse.response, UserLoginResponse.class);
        }
        catch (Exception e)
        {
            return errorResponse;
        }
    }

    public static List<TaskInformation> GetTaskList(String userName, AuditStatus auditStatus)
    {
        GetTaskListRequest request = new GetTaskListRequest();
        request.auditStatus = auditStatus;
        request.username = userName;

        String requestEntity = gson.toJson(request);

        EAuditingHttpResponse response = HttpWrapper.HttpPost("/android/tasklist", requestEntity);
        GetTaskListResponse taskListResponse = gson.fromJson(response.response, GetTaskListResponse.class);
        return taskListResponse.taskInformationList;
    }

    public static TaskDetailResponse GetTaskDetail(String taskid)
    {
        String requestFormat = String.format("/android/taskdetail?taskid=%s", taskid);
        EAuditingHttpResponse response = HttpWrapper.HttpGet(requestFormat);
        return gson.fromJson(response.response, TaskDetailResponse.class);
    }

}