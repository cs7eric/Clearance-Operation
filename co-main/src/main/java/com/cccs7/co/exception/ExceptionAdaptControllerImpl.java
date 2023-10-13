package com.cccs7.co.exception;

import com.cccs7.web.bean.Result;
import com.cccs7.web.bean.ResultCode;
import com.cccs7.web.common.ExceptionAdaptController;
import com.cccs7.web.exception.*;
import io.lettuce.core.pubsub.RedisPubSubListener;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.security.auth.login.AccountLockedException;

/**
 * <p> 异常处理器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 异常处理器
 * @Date 2023/8/8 13:00
 */
@RestControllerAdvice
public class ExceptionAdaptControllerImpl implements ExceptionAdaptController {


    @Override
    @ExceptionHandler(RuntimeException.class)
    public Result handlerRuntimeException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        String message = runtimeException.getMessage();
        return Result.fail(ResultCode.ERROR_CODE, message);
    }

    @Override
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception) {
        exception.printStackTrace();
        String message = exception.getMessage();
        return Result.fail(ResultCode.ERROR_CODE, message);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result handlerAccessDeniedException(AccessDeniedException accessDeniedException) {
        throw accessDeniedException;
    }

    /**
     * 登录失败异常
     *
     * @param loginFailedException 登录失败
     * @return
     */
    @ExceptionHandler(LoginFailedException.class)
    public Result<String> handlerLoginFailedException(LoginFailedException loginFailedException) {
        loginFailedException.printStackTrace();
        return Result.fail(ExceptionInfo.LOGIN_FAILED);
    }

    /**
     * 用户业务相关异常
     *
     * @param userBusinessException 用户业务相关异常
     * @return
     */
    @ExceptionHandler(UserBusinessException.class)
    public Result<String> handlerUserBusinessException(UserBusinessException userBusinessException) {
        return Result.fail(userBusinessException.getMessage());
    }

    /**
     * 超过文件上传最大限制
     *
     * @param maxUploadSizeExceededException 超过文件上传最大限制
     * @return
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<String> handler(MaxUploadSizeExceededException maxUploadSizeExceededException) {
        return Result.fail(ExceptionInfo.MAX_UPLOAD_SIZE_EXCEEDED_ERROR);
    }

    /**
     * 当前用户不存在
     *
     * @param userNotExistException 当前用户不存在
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public Result<String> handlerUserNotExistException(UserNotExistException userNotExistException) {
        return Result.fail(ExceptionInfo.USER_NOT_EXIST);
    }

    /**
     * 用户已存在
     * @param userAlreadyExistException 用户已存在
     * @return
     */
    @ExceptionHandler(UserAlreadyExistException.class)
    public Result<String> handlerUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        return Result.fail(ExceptionInfo.USER_ALREADY_EXISTS);
    }

    /**
     * 用户被锁定
     *
     * @param accountLockedException 用户被锁定
     * @return
     */
    @ExceptionHandler(AccountLockedException.class)
    public Result<String> handlerAccountLockedException(AccountLockedException accountLockedException) {
        return Result.fail(ExceptionInfo.ACCOUNT_LOCKED);
    }


    /**
     * 用户 id 不存在
     *
     * @param userIdNotExistException 用户id不存在
     * @return 用户 ID 不存在
     */
    @ExceptionHandler(UserIdNotExistException.class)
    public Result<String> handlerUserIdNotExistException(UserIdNotExistException userIdNotExistException) {
        return Result.fail(ExceptionInfo.USER_ID_NOT_EXIST);
    }

    /**
     * 用户名重复
     *
     * @param userNameDuplicatedException 用户名重复
     * @return 用户名重复
     */
    @ExceptionHandler(UserNameDuplicatedException.class)
    public Result<String> handlerUserNameDuplicatedException(UserNameDuplicatedException userNameDuplicatedException) {
        return Result.fail(ExceptionInfo.USERNAME_DUPLICATED);
    }

    /**
     * 用户密码错误
     *
     * @param userPasswordErrorException 用户密码错误
     * @return 用户密码错误
     */
    @ExceptionHandler(UserPasswordErrorException.class)
    public Result<String> handlerPasswordErrorException(UserPasswordErrorException userPasswordErrorException) {
        return Result.fail(ExceptionInfo.USER_PASSWORD_ERROR);
    }

    /**
     * 该文章不存在
     *
     * @param articleNotExistException 该文章不存在
     * @return 所查询文章不存在
     */
    @ExceptionHandler(ArticleNotExistException.class)
    public Result<String> handlerArticleNotExistException(ArticleNotExistException articleNotExistException) {
        return Result.fail(ExceptionInfo.ARTICLE_NOT_EXIST);
    }

    /**
     * 用户未登录
     *
     * @param userNotLoginException 用户未登录
     * @return fail(" 用户未登录 ")
     */
    @ExceptionHandler(UserNotLoginException.class)
    public Result<String> handlerUserNotLoginException(UserNotLoginException userNotLoginException) {
        return Result.fail(ExceptionInfo.USER_NOT_LOGIN);
    }

    /**
     * 密码修改失败
     *
     * @param passwordEditFailedException 密码修改失败
     * @return fail(" 密码修改失败 ")
     */
    @ExceptionHandler(PasswordEditFailedException.class)
    public Result<String> handlerPasswordEditFailedException(PasswordEditFailedException passwordEditFailedException) {
        return Result.fail(ExceptionInfo.PASSWORD_EDIT_FAILED);
    }

    /**
     * 文件上传失败
     *
     * @param fileUploadFailedException 文件上传失败
     * @return
     */
    @ExceptionHandler(FileUploadFailedException.class)
    public Result<String> handlerFileUploadFailedException(FileUploadFailedException fileUploadFailedException) {
        return Result.fail(ExceptionInfo.FILE_UPLOAD_FAILED);
    }

    /**
     * 非法字符
     *
     * @param invaildSymbolException 非法字符
     * @return
     */
    @ExceptionHandler(InvaildSymbolException.class)
    public Result<String> handlerInvaildSymbolException(InvaildSymbolException invaildSymbolException) {
        return Result.fail(ExceptionInfo.INVAILD_SYMBOL);
    }

    /**
     * 评论失败
     * @param commentFailedException 评论失败
     * @return fail("评论失败")
     */
    @ExceptionHandler(CommentFailedException.class)
    public Result<String> handlerCommentFailedException(CommentFailedException commentFailedException){
        return Result.fail(ExceptionInfo.COMMENT_FAILED);
    }

    /**
     * 点赞失败
     * @param clickLikeFailedException
     * @return
     */
    @ExceptionHandler(ClickLikeFailedException.class)
    public Result<String> handlerClickLikeFailedException(ClickLikeFailedException clickLikeFailedException){
        return Result.fail(ExceptionInfo.CLICK_LIKE_FAILED);
    }

    /**
     * 收藏失败
     *
     * @param collectFailedException 收藏失败
     * @return
     */
    @ExceptionHandler(CollectFailedException.class)
    public Result<String> handlerCollectFailedException(CollectFailedException collectFailedException){
        return Result.fail(ExceptionInfo.COLLECT_FAILED);
    }

    /**
     * 举报失败
     * @param reportFailedException 举报失败
     * @return
     */
    @ExceptionHandler(ReportFailedException.class)
    public Result<String> handlerReportFailedException(ReportFailedException reportFailedException){
        return Result.fail(ExceptionInfo.REPORT_FAILED);
    }

    /**
     * 发布文章失败
     * @param articlePublishFailedException 发布文章失败
     * @return
     */
    @ExceptionHandler(ArticlePublishFailedException.class)
    public Result<String> handlerArticlePublicFailed(ArticlePublishFailedException articlePublishFailedException){
        return Result.fail(ExceptionInfo.ARTICLE_PUBLISH_FAILED);
    }

    @ExceptionHandler(CodeException.class)
    public Result<String> handleCodeException(CodeException codeException) {
        return Result.fail(ExceptionInfo.CODE_ERROR);
    }

}
