package com.example.spring_project.constant;

public class UrlConst {

    /** ログイン画面 */
	public static final String LOGIN = "/login";

	/** ユーザー登録画面 */
	public static final String SIGNUP = "/signup";

	/** メニュー画面 */
	public static final String MAIN = "/main";

	/** 投稿画面 */
	public static final String POST = "/post";

	/** パスワード変更画面 */
	public static final String Forgot_PASS = "/new";

	/** マイページ画面 */
	public static final String MYPAGE = "/mypage";

	/** ログアウト画面 */
	public static final String LOGOUT = "/logout";

	/** 認証不要画面 */
	public static final String[] NO_AUTHENTICATION = { LOGIN, SIGNUP, Forgot_PASS, "/css/**", "/js/**", "/webjars/**" };
	
}
