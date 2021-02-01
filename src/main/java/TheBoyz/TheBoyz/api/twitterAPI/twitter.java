//package TheBoyz.TheBoyz.api.twitterAPI;
//
//import twitter4j.*;
//import twitter4j.api.*;
//import twitter4j.auth.AccessToken;
//import twitter4j.auth.Authorization;
//import twitter4j.auth.OAuth2Token;
//import twitter4j.auth.RequestToken;
//import twitter4j.conf.Configuration;
//import twitter4j.util.function.Consumer;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.net.URI;
//import java.util.Map;
//import java.util.Scanner;
//import twitter4j.conf.ConfigurationBuilder;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpClient;
//
//
//
//
//public class twitter {
//
//    private static PrintStream consolePrint;
//
//    public static void main(String[] args) throws TwitterException, IOException, InterruptedException {
//
//        var url = "https://twitter.com/SocialHubClub";
//
//        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
//
//       var client = HttpClient.newBuilder().build();
//
//       var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("this is the response: " + response.statusCode());
//
//
//        Twitter bigBird = new Twitter() {
//
//
//            /**
//             * sets the OAuth consumer key and consumer secret
//             *
//             * @param consumerKey    OAuth consumer key
//             * @param consumerSecret OAuth consumer secret
//             * @throws IllegalStateException when OAuth consumer has already been set, or the instance is using basic authorization
//             * @since Twitter 2.0.0
//             */
//            @Override
//            public void setOAuthConsumer(String consumerKey, String consumerSecret) {
//
//            }
//
//            /**
//             * Retrieves a request token
//             *
//             * @return generated request token.
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException access token is already available
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | Twitter Developers</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step1">OAuth Core 1.0a - 6.1.  Obtaining an Unauthorized Request Token</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/request_token">POST oauth/request_token | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public RequestToken getOAuthRequestToken() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves a request token
//             *
//             * @param callbackURL callback URL
//             * @return generated request token
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException access token is already available
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | Twitter Developers</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step1">OAuth Core 1.0a - 6.1.  Obtaining an Unauthorized Request Token</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/request_token">POST oauth/request_token | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public RequestToken getOAuthRequestToken(String callbackURL) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves a request token
//             *
//             * @param callbackURL     callback URL
//             * @param xAuthAccessType Overrides the access level an application requests to a users account. Supported values are read or write. This parameter is intended to allow a developer to register a read/write application but also request read only access when appropriate.
//             * @return generated request token
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException access token is already available
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | Twitter Developers</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step1">OAuth Core 1.0a - 6.1.  Obtaining an Unauthorized Request Token</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/request_token">POST oauth/request_token | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public RequestToken getOAuthRequestToken(String callbackURL, String xAuthAccessType) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves a request token
//             *
//             * @param callbackURL     callback URL
//             * @param xAuthAccessType Overrides the access level an application requests to a users account. Supported values are read or write. This parameter is intended to allow a developer to register a read/write application but also request read only access when appropriate.
//             * @param xAuthMode       Set to reverse_auth to obtain a special request token to be used in the reverse auth process.
//             * @return generated request token
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException access token is already available
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | Twitter Developers</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step1">OAuth Core 1.0a - 6.1.  Obtaining an Unauthorized Request Token</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/request_token">POST oauth/request_token | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public RequestToken getOAuthRequestToken(String callbackURL, String xAuthAccessType, String xAuthMode) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an access token associated with this instance.<br>
//             * If no access token is associated with this instance, this will retrieve a new access token.
//             *
//             * @return access token
//             * @throws TwitterException      when Twitter service or network is unavailable, or the user has not authorized
//             * @throws IllegalStateException when RequestToken has never been acquired
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | dev.twitter.com - How long does an access token last?</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step2">OAuth Core 1.0a - 6.2.  Obtaining User Authorization</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/access_token">POST oauth/access_token | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public AccessToken getOAuthAccessToken() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves an access token.
//             *
//             * @param oauthVerifier OAuth verifier. AKA pin.
//             * @return access token
//             * @throws TwitterException when Twitter service or network is unavailable, or the user has not authorized
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | dev.twitter.com - How long does an access token last?</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step2">OAuth Core 1.0a - 6.2.  Obtaining User Authorization</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/access_token">POST oauth/access_token | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public AccessToken getOAuthAccessToken(String oauthVerifier) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves an access token associated with the supplied request token and sets userId.
//             *
//             * @param requestToken the request token
//             * @return access token associated with the supplied request token.
//             * @throws TwitterException when Twitter service or network is unavailable, or the user has not authorized
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | dev.twitter.com - How long does an access token last?</a>
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step2">OAuth Core 1.0a - 6.2.  Obtaining User Authorization</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/access_token">POST oauth/access_token | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public AccessToken getOAuthAccessToken(RequestToken requestToken) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves an access token associated with the supplied request token and sets userId.
//             *
//             * @param requestToken  the request token
//             * @param oauthVerifier OAuth verifier. AKA pin.
//             * @return access token associated with the supplied request token.
//             * @throws TwitterException when Twitter service or network is unavailable, or the user has not authorized
//             * @see <a href="http://oauth.net/core/1.0a/#auth_step2">OAuth Core 1.0a - 6.2.  Obtaining User Authorization</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/access_token">POST oauth/access_token | Twitter Developers</a>
//             * @since Twitter 2.1.1
//             */
//            @Override
//            public AccessToken getOAuthAccessToken(RequestToken requestToken, String oauthVerifier) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieves an access token associated with the supplied screen name and password using xAuth.<br>
//             * In order to get access acquire AccessToken using xAuth, you must apply by sending an email to api@twitter.com — all other applications will receive an HTTP 401 error.  Web-based applications will not be granted access, except on a temporary basis for when they are converting from basic-authentication support to full OAuth support.<br>
//             * Storage of Twitter usernames and passwords is forbidden. By using xAuth, you are required to store only access tokens and access token secrets. If the access token expires or is expunged by a user, you must ask for their login and password again before exchanging the credentials for an access token.
//             *
//             * @param screenName the screen name
//             * @param password   the password
//             * @return access token associated with the supplied request token.
//             * @throws TwitterException when Twitter service or network is unavailable, or the user has not authorized
//             * @see <a href="https://dev.twitter.com/docs/auth/oauth/faq">OAuth FAQ | dev.twitter.com - How long does an access token last?</a>
//             * @see <a href="https://dev.twitter.com/docs/oauth/xauth">xAuth | Twitter Developers</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth/access_token">POST oauth/access_token | Twitter Developers</a>
//             * @since Twitter 2.1.1
//             */
//            @Override
//            public AccessToken getOAuthAccessToken(String screenName, String password) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sets the access token
//             *
//             * @param accessToken accessToken
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public void setOAuthAccessToken(AccessToken accessToken) {
//
//            }
//
//            /**
//             * Obtains an OAuth 2 Bearer token.
//             *
//             * @return OAuth 2 Bearer token
//             * @throws TwitterException      when Twitter service or network is unavailable, or connecting non-SSL endpoints.
//             * @throws IllegalStateException when Bearer token is already available, or OAuth consumer is not available.
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/oauth2/token">POST oauth2/token | Twitter Developers</a>
//             */
//            @Override
//            public OAuth2Token getOAuth2Token() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sets the OAuth 2 Bearer token.
//             *
//             * @param oauth2Token OAuth 2 Bearer token
//             */
//            @Override
//            public void setOAuth2Token(OAuth2Token oauth2Token) {
//
//            }
//
//            /**
//             * Revokes an issued OAuth 2 Bearer Token.
//             *
//             * @throws TwitterException      when Twitter service or network is unavailable, or connecting non-SSL endpoints.
//             * @throws IllegalStateException when Bearer token is not available.
//             */
//            @Override
//            public void invalidateOAuth2Token() throws TwitterException {
//
//            }
//
//            /**
//             * Returns the current trend, geo, language, timezone and sleep time information for the authenticating user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/account/settings.json
//             *
//             * @return the current trend, geo and sleep time information for the authenticating user.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/account/settings">GET account/settings | Twitter Developers</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public AccountSettings getAccountSettings() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an HTTP 200 OK response code and a representation of the requesting user if authentication was successful; returns a 401 status code and an error message if not.  Use this method to test if supplied user credentials are valid.
//             * <br>This method calls https://api.twitter.com/1.1/account/verify_credentials.json
//             *
//             * @return user
//             * @throws TwitterException when Twitter service or network is unavailable, or if supplied credential is wrong (TwitterException.getStatusCode() == 401)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/account/verify_credentials">GET account/verify_credentials | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             */
//            @Override
//            public User verifyCredentials() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the current trend, geo, language, timezone and sleep time information for the authenticating user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/account/settings.json
//             *
//             * @param trendLocationWoeid Optional. The Yahoo! Where On Earth ID to use as the user's default trend location.
//             * @param sleepTimeEnabled   Optional. Whether sleep time is enabled for the user
//             * @param startSleepTime     Optional. The hour that sleep time should begin if it is enabled.
//             * @param endSleepTime       Optional. The hour that sleep time should end if it is enabled.
//             * @param timeZone           Optional. The timezone dates and times should be displayed in for the user.
//             * @param lang               Optional. The language which Twitter should render in for this user. (two letter ISO 639-1)
//             * @return the current trend, geo and sleep time information for the authenticating user.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/settings">POST account/settings | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public AccountSettings updateAccountSettings(Integer trendLocationWoeid, Boolean sleepTimeEnabled, String startSleepTime, String endSleepTime, String timeZone, String lang) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the allowDmsFrom settings for the authenticating user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/account/settings.json
//             * <br>This method requires whitelisting from Twitter: https://twittercommunity.com/t/api-updates-for-direct-messages-rules/36061
//             *
//             * @param allowDmsFrom Optional. "all" for anyone, "followers" for friends only
//             * @return the current trend, geo and sleep time information for the authenticating user.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public AccountSettings updateAllowDmsFrom(String allowDmsFrom) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sets values that users are able to set under the "Account" tab of their settings page. Only the parameters specified(non-null) will be updated.
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile.json
//             *
//             * @param name        Optional. Maximum of 20 characters.
//             * @param url         Optional. Maximum of 100 characters. Will be prepended with "http://" if not present.
//             * @param location    Optional. Maximum of 30 characters. The contents are not normalized or geocoded in any way.
//             * @param description Optional. Maximum of 160 characters.
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile">POST account/update_profile | Twitter Developers</a>
//             * @since Twitter4J 2.1.8
//             */
//            @Override
//            public User updateProfile(String name, String url, String location, String description) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's profile background image.
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_background_image.json
//             *
//             * @param image Must be a valid GIF, JPG, or PNG image of less than 800 kilobytes in size.  Images with width larger than 2048 pixels will be forceably scaled down.
//             * @param tile  If set to true the background image will be displayed tiled. The image will not be tiled otherwise.
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_background_image">POST account/update_profile_background_image | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             * @deprecated Since Twitter4J 4.0.7
//             */
//            @Override
//            public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's profile background image.
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_background_image.json
//             *
//             * @param image Must be a valid GIF, JPG, or PNG image of less than 800 kilobytes in size.  Images with width larger than 2048 pixels will be forceably scaled down.
//             * @param tile  If set to true the background image will be displayed tiled. The image will not be tiled otherwise.
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_background_image">POST account/update_profile_background_image | Twitter Developers</a>
//             * @since Twitter4J 2.1.11
//             */
//            @Override
//            public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sets one or more hex values that control the color scheme of the authenticating user's profile page on twitter.com. Each parameter's value must be a valid hexadecimal value, and may be either three or six characters (ex: #fff or #ffffff).
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_colors.json
//             *
//             * @param profileBackgroundColor    optional, can be null
//             * @param profileTextColor          optional, can be null
//             * @param profileLinkColor          optional, can be null
//             * @param profileSidebarFillColor   optional, can be null
//             * @param profileSidebarBorderColor optional, can be null
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_colors">POST account/update_profile_colors | Twitter Developers</a>
//             * @since Twitter4J 2.0.0
//             * @deprecated Since Twitter4J 4.0.5
//             */
//            @Override
//            public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor, String profileSidebarBorderColor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's profile image.
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_image.json
//             *
//             * @param image Must be a valid GIF, JPG, or PNG image of less than 700 kilobytes in size.  Images with width larger than 500 pixels will be scaled down.
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_image">POST account/update_profile_image | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User updateProfileImage(File image) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's profile image.
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_image.json
//             *
//             * @param image Must be a valid GIF, JPG, or PNG image of less than 700 kilobytes in size.  Images with width larger than 500 pixels will be scaled down.
//             * @return the updated user
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_image">POST account/update_profile_image | Twitter Developers</a>
//             * @since Twitter4J 2.1.11
//             */
//            @Override
//            public User updateProfileImage(InputStream image) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of user objects that the authenticating user is blocking.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/blocking.json
//             *
//             * @return a list of user objects that the authenticating user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/blocks/blocking">GET blocks/blocking | Twitter Developers</a>
//             * @since Twitter4J 2.0.4
//             */
//            @Override
//            public PagableResponseList<User> getBlocksList() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of user objects that the authenticating user is blocking.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/blocking.json
//             *
//             * @param cursor Causes the list of blocked users to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page."
//             * @return a list of user objects that the authenticating user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/blocks/blocking">GET blocks/blocking | Twitter Developers</a>
//             * @since Twitter4J 2.0.4
//             */
//            @Override
//            public PagableResponseList<User> getBlocksList(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric user ids the authenticating user is blocking.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/ids
//             *
//             * @return Returns an array of numeric user ids the authenticating user is blocking.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/blocks/ids">GET blocks/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.4
//             */
//            @Override
//            public IDs getBlocksIDs() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric user ids the authenticating user is blocking.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/ids
//             *
//             * @param cursor cursor
//             * @return Returns an array of numeric user ids the authenticating user is blocking.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/blocks/ids">GET blocks/ids | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public IDs getBlocksIDs(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Blocks the user specified in the ID parameter as the authenticating user.  Returns the blocked user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/create/[id].json
//             *
//             * @param userId the ID of the user to block
//             * @return the blocked user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/blocks/create">POST blocks/create | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User createBlock(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Blocks the user specified in the ID parameter as the authenticating user.  Returns the blocked user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/create/[id].json
//             *
//             * @param screenName the screen_name of the user to block
//             * @return the blocked user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/blocks/create">POST blocks/create | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public User createBlock(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Un-blocks the user specified in the ID parameter as the authenticating user.  Returns the un-blocked user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/destroy/[id].json
//             *
//             * @param userId the ID of the user to block
//             * @return the unblocked user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/blocks/destroy">POST blocks/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public User destroyBlock(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Un-blocks the user specified in the ID parameter as the authenticating user.  Returns the un-blocked user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/blocks/destroy/[id].json
//             *
//             * @param screen_name the screen_name of the user to block
//             * @return the unblocked user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/blocks/destroy">POST blocks/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public User destroyBlock(String screen_name) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of user objects that the authenticating user is muting.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/list
//             *
//             * @param cursor Causes the list of muted users to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page."
//             * @return a list of user objects that the authenticating user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/mutes/users/list">GET blocks/blocking | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getMutesList(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric user ids the authenticating user is muting.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/ids
//             *
//             * @param cursor Causes the list of muted users to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page."
//             * @return Returns an array of numeric user ids the authenticating user is muting.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/mutes/users/ids">GET blocks/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getMutesIDs(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Mutes the user specified in the ID parameter as the authenticating user.  Returns the muted user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/create
//             *
//             * @param userId the user_id of the user to mute
//             * @return the muted user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/mutes/users/create">POST mutes/users/create | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public User createMute(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Mutes the user specified in the screen name parameter as the authenticating user.  Returns the muted user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/create
//             *
//             * @param screenName the screen_name of the user to mute
//             * @return the muted user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/mutes/users/create">POST mutes/users/create | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public User createMute(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Un-mutes the user specified in the ID parameter as the authenticating user.  Returns the un-muted user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/destroy
//             *
//             * @param userId the ID of the user to mute
//             * @return the unmuted user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/mutes/users/destroy">POST mutes/users/destroy | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public User destroyMute(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Un-mutes the user specified in the screen name parameter as the authenticating user.  Returns the un-muted user in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/mutes/users/destroy
//             *
//             * @param screenName the screen_name of the user to mute
//             * @return the unmuted user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/mutes/users/destroy">POST mutes/users/destroy | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public User destroyMute(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two. The author's most recent status (if the authenticating user has permission) will be returned inline.
//             * <br>This method calls https://api.twitter.com/1.1/users/lookup.json
//             *
//             * @param ids Specifies the IDs of the users to return.
//             * @return users
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/lookup">GET users/lookup | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<User> lookupUsers(long... ids) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Return up to 100 users worth of extended information, specified by either ID, screen name, or combination of the two. The author's most recent status (if the authenticating user has permission) will be returned inline.
//             * <br>This method calls https://api.twitter.com/1.1/users/lookup.json
//             *
//             * @param screenNames Specifies the screen names of the users to return.
//             * @return users
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/lookup">GET users/lookup | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<User> lookupUsers(String... screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns extended information of a given user, specified by ID or screen name as per the required id parameter. The author's most recent status will be returned inline.
//             * <br>This method calls https://api.twitter.com/1.1/users/show.json
//             *
//             * @param userId the ID of the user for whom to request the detail
//             * @return users
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/show">GET users/show | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User showUser(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns extended information of a given user, specified by ID or screen name as per the required id parameter. The author's most recent status will be returned inline.
//             * <br>This method calls https://api.twitter.com/1.1/users/show.json
//             *
//             * @param screenName the screen name of the user for whom to request the detail
//             * @return User
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/show">GET users/show | Twitter Developers</a>
//             */
//            @Override
//            public User showUser(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Run a search for users similar to the Find People button on Twitter.com; the same results returned by people search on Twitter.com will be returned by using this API.<br>
//             * Usage note: It is only possible to retrieve the first 1000 matches from this API.
//             * <br>This method calls https://api.twitter.com/1.1/users/search.json
//             *
//             * @param query The query to run against people search.
//             * @param page  Specifies the page of results to retrieve. Number of statuses per page is fixed to 20.
//             * @return the list of Users matches the provided
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/search">GET users/search | Twitter Developers</a>
//             */
//            @Override
//            public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of users that the specified user can contribute to.
//             *
//             * @param userId The user id of the user for whom to return results for
//             * @return list of contributors
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/contributees">GET users/contributors | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<User> getContributees(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of users that the specified user can contribute to.
//             *
//             * @param screenName The screen name of the user for whom to return results for
//             * @return list of contributors
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/contributees">GET users/contributors | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<User> getContributees(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of users who can contribute to the specified account.
//             *
//             * @param userId The user id of the user for whom to return results for
//             * @return list of contributors
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/contributors">GET users/contributors | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<User> getContributors(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of users who can contribute to the specified account.
//             *
//             * @param screenName The screen name of the user for whom to return results for
//             * @return list of contributors
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/contributors">GET users/contributors | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<User> getContributors(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the uploaded profile banner for the authenticating user. Returns HTTP 200 upon success.
//             * <br>This method calls https://api.twitter.com/1.1/account/remove_profile_banner.json
//             *
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/remove_profile_banner">POST account/remove_profile_banner | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public void removeProfileBanner() throws TwitterException {
//
//            }
//
//            /**
//             * Uploads a profile banner on behalf of the authenticating user. For best results, upload an &lt;5MB image that is exactly 1252px by 626px. Images will be resized for a number of display options. Users with an uploaded profile banner will have a profile_banner_url node in their <a href="https://dev.twitter.com/docs/platform-objects/users">Users</a> objects. More information about sizing variations can be found in <a href="https://dev.twitter.com/docs/user-profile-images-and-banners">User Profile Images and Banners</a>.<br>
//             * Profile banner images are processed asynchronously. The profile_banner_url and its variant sizes will not necessary be available directly after upload.<br>
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_banner.json
//             *
//             * @param image For best results, upload an &lt;5MB image that is exactly 1252px by 626px.
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_banner">POST account/update_profile_banner | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public void updateProfileBanner(File image) throws TwitterException {
//
//            }
//
//            /**
//             * Uploads a profile banner on behalf of the authenticating user. For best results, upload an &lt;5MB image that is exactly 1252px by 626px. Images will be resized for a number of display options. Users with an uploaded profile banner will have a profile_banner_url node in their <a href="https://dev.twitter.com/docs/platform-objects/users">Users</a> objects. More information about sizing variations can be found in <a href="https://dev.twitter.com/docs/user-profile-images-and-banners">User Profile Images and Banners</a>.<br>
//             * Profile banner images are processed asynchronously. The profile_banner_url and its variant sizes will not necessary be available directly after upload.<br>
//             * <br>This method calls https://api.twitter.com/1.1/account/update_profile_banner.json
//             *
//             * @param image For best results, upload an &lt;5MB image that is exactly 1252px by 626px.
//             * @throws TwitterException when Twitter service or network is unavailable,
//             *                          or when the specified file is not found (FileNotFoundException will be nested),
//             *                          or when the specified file object in not representing a file (IOException will be nested)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/account/update_profile_banner">POST account/update_profile_banner | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public void updateProfileBanner(InputStream image) throws TwitterException {
//
//            }
//
//            /**
//             * Returns up to 100 of the first retweets of a given tweet.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/retweets
//             *
//             * @param statusId The numerical ID of the tweet you want the retweets of.
//             * @return the retweets of a given tweet
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/retweets/:id">Tweets Resources › statuses/retweets/:id</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a collection of up to 100 user IDs belonging to users who have
//             * retweeted the tweet specified by the id parameter.
//             * <br>This method calls https://api.twitter.com/1.1/get/statuses/retweeters/ids
//             *
//             * @param statusId The numerical ID of the tweet you want the retweeters of.
//             * @param cursor   The cursor of the page to fetch. Use -1 to start.
//             * @return the retweets of a given tweet
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/retweeters/ids">Tweets Resources › statuses/retweeters/ids</a>
//             * @since Twitter4J 3.0.5
//             */
//            @Override
//            public IDs getRetweeterIds(long statusId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a collection of up to {@code count} user IDs belonging to users
//             * who have retweeted the tweet specified by the id parameter.
//             * <br>This method calls https://api.twitter.com/1.1/get/statuses/retweeters/ids
//             *
//             * @param statusId The numerical ID of the tweet you want the retweeters of.
//             * @param count    The maximum number of retweeter IDs to retrieve. Must be
//             *                 between 1 and 200, inclusive.
//             * @param cursor   The cursor of the page to fetch. Use -1 to start.
//             * @return the retweets of a given tweet
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/retweeters/ids">Tweets Resources › statuses/retweeters/ids</a>
//             * @since Twitter4J 3.0.5
//             */
//            @Override
//            public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a single status, specified by the id parameter below. The status's author will be returned inline.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/show
//             *
//             * @param id the numerical ID of the status you're trying to retrieve
//             * @return a single status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/show/:id">GET statuses/show/:id | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public Status showStatus(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Destroys the status specified by the required ID parameter.<br>
//             * Usage note: The authenticating user must be the author of the specified status.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/destroy
//             *
//             * @param statusId The ID of the status to destroy.
//             * @return the deleted status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/destroy/:id">POST statuses/destroy/:id | Twitter Developers</a>
//             * @since 1.0.5
//             */
//            @Override
//            public Status destroyStatus(long statusId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's status. A status update with text identical to the authenticating user's text identical to the authenticating user's current status will be ignored to prevent duplicates.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/update
//             *
//             * @param status the text of your status update
//             * @return the latest status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/update">POST statuses/update | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public Status updateStatus(String status) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the authenticating user's status. A status update with text identical to the authenticating user's text identical to the authenticating user's current status will be ignored to prevent duplicates.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/update or<br>
//             * This method calls https://upload.twitter.com/1/statuses/update_with_media
//             *
//             * @param latestStatus the latest status to be updated.
//             * @return the latest status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/update">POST statuses/update | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public Status updateStatus(StatusUpdate latestStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retweets a tweet. Returns the original tweet with retweet details embedded.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/retweet
//             *
//             * @param statusId The ID of the status to retweet.
//             * @return the retweeted status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/retweet/:id">POST statuses/retweet/:id | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public Status retweetStatus(long statusId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Untweets a retweeted status. Returns the original Tweet with retweet details embedded.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/unretweet
//             *
//             * @param statusId The ID of the status to un-retweet.
//             * @return the original Tweet with retweet details embedded
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/unretweet/:id">POST statuses/unretweet/:id | Twitter Developers</a>
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public Status unRetweetStatus(long statusId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns information allowing the creation of an embedded representation of a Tweet on third party sites. See the <a href="http://oembed.com/">oEmbed</a> specification for information about the response format.
//             * While this endpoint allows a bit of customization for the final appearance of the embedded Tweet, be aware that the appearance of the rendered Tweet may change over time to be consistent with Twitter's <a href="https://dev.twitter.com/terms/display-requirements">Display Requirements</a>. Do not rely on any class or id parameters to stay constant in the returned markup.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/oembed.json
//             *
//             * @param req request
//             * @return information allowing the creation of an embedded representation of a Tweet on third party sites
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/oembed">GET statuses/oembed | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns fully-hydrated tweet objects for up to 100 tweets per request, as specified by comma-separated values passed to the id parameter.
//             * This method is especially useful to get the details (hydrate) a collection of Tweet IDs.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/lookup.json
//             *
//             * @param ids array of the ids to lookup
//             * @return list of the tweets
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/lookup">GET statuses/lookup</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public ResponseList<Status> lookup(long... ids) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Uploads media image to be attached via {@link #updateStatus(StatusUpdate)}
//             * <br>This method calls https://api.twitter.com/1.1/media/upload.json
//             *
//             * @param mediaFile the latest status to be updated.
//             * @return upload result
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/update">POST statuses/update | Twitter Developers</a>
//             * @see <a href="https://dev.twitter.com/docs/api/multiple-media-extended-entities">Multiple Media Entities in Statuses</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public UploadedMedia uploadMedia(File mediaFile) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Uploads media image to be attached via {@link #updateStatus(StatusUpdate)}
//             * <br>This method calls https://api.twitter.com/1.1/media/upload.json
//             *
//             * @param fileName media file name
//             * @param media    media body as stream
//             * @return upload result
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/update">POST statuses/update | Twitter Developers</a>
//             * @see <a href="https://dev.twitter.com/docs/api/multiple-media-extended-entities">Multiple Media Entities in Statuses</a>
//             * @since Twitter4J 4.0.3
//             */
//            @Override
//            public UploadedMedia uploadMedia(String fileName, InputStream media) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Uploads media using chunked approach to be attached via {@link #updateStatus(StatusUpdate)}.
//             * This should be used for videos.
//             * <br>This method calls https://api.twitter.com/1.1/media/upload.json
//             *
//             * @param fileName media file name
//             * @param media    media body as stream
//             * @return upload result
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/rest/public/uploading-media#chunkedupload">Uploading Media | Twitter Developers</a>
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/statuses/update">POST statuses/update | Twitter Developers</a>
//             * @see <a href="https://dev.twitter.com/docs/api/multiple-media-extended-entities">Multiple Media Entities in Statuses</a>
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public UploadedMedia uploadMediaChunked(String fileName, InputStream media) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the top 10 trending topics for a specific WOEID, if trending information is available for it.<br>
//             * The response is an array of "trend" objects that encode the name of the trending topic, the query parameter that can be used to search for the topic on <a href="http://search.twitter.com/">Twitter Search</a>, and the Twitter Search URL.<br>
//             * This information is cached for 5 minutes. Requesting more frequently than that will not return any more data, and will count against your rate limit usage.<br>
//             * <br>This method calls https://api.twitter.com/1.1/trends/place.json
//             *
//             * @param woeid <a href="http://developer.yahoo.com/geo/geoplanet/">The Yahoo! Where On Earth ID</a> of the location to return trending information for. Global information is available by using 1 as the WOEID.
//             * @return trends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/trends/place">GET trends/place | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public Trends getPlaceTrends(int woeid) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the locations that Twitter has trending topic information for. The response is an array of &quot;locations&quot; that encode the location's WOEID (a <a href="http://developer.yahoo.com/geo/geoplanet/">Yahoo! Where On Earth ID</a>) and some other human-readable information such as a canonical name and country the location belongs in.
//             * <br>This method calls https://api.twitter.com/1.1/trends/available.json
//             *
//             * @return the locations
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/trends/available">GET trends/available | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<Location> getAvailableTrends() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the locations that Twitter has trending topic information for, closest to a specified location.<br>
//             * The response is an array of "locations" that encode the location's WOEID and some other human-readable information such as a canonical name and country the location belongs in.<br>
//             * A WOEID is a <a href="http://developer.yahoo.com/geo/geoplanet/">Yahoo! Where On Earth ID</a>.
//             * <br>This method calls https://api.twitter.com/1.1/trends/closest.json
//             *
//             * @param location the available trend locations will be sorted by distance to the lat and long passed in. The sort is nearest to furthest.
//             * @return the locations
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/trends/closest">GET trends/closest | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public ResponseList<Location> getClosestTrends(GeoLocation location) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent mentions (tweets containing a users's @screen_name) for the authenticating user.<br>
//             * The timeline returned is the equivalent of the one seen when you view your mentions on twitter.com.<br>
//             * This method can only return up to 800 tweets.<br>
//             * See <a href="https://dev.twitter.com/docs/working-with-timelines">Working with Timelines</a> for instructions on traversing timelines.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/mentions_timeline
//             *
//             * @return the 20 most recent replies
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/mentions">GET statuses/mentions | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<Status> getMentionsTimeline() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent mentions (tweets containing a users's @screen_name) for the authenticating user.<br>
//             * The timeline returned is the equivalent of the one seen when you view your mentions on twitter.com.<br>
//             * This method can only return up to 800 tweets.<br>
//             * See <a href="https://dev.twitter.com/docs/working-with-timelines">Working with Timelines</a> for instructions on traversing timelines.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/mentions_timeline
//             *
//             * @param paging controls pagination. Supports since_id, max_id, zcount parameters.
//             * @return the 20 most recent replies
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/mentions">GET statuses/mentions | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline.json
//             *
//             * @param screenName specifies the screen name of the user for whom to return the user_timeline
//             * @param paging     controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of the user Timeline
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline(String screenName, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline.json
//             *
//             * @param userId specifies the ID of the user for whom to return the user_timeline
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of the user Timeline
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline(long userId, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline
//             *
//             * @param screenName specifies the screen name of the user for whom to return the user_timeline
//             * @return the 20 most recent statuses posted in the last 24 hours from the user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline
//             *
//             * @param userId specifies the ID of the user for whom to return the user_timeline
//             * @return the 20 most recent statuses posted in the last 24 hours from the user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline
//             *
//             * @return the 20 most recent statuses posted in the last 24 hours from the user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses posted from the authenticating user. It's also possible to request another user's timeline via the id parameter.<br>
//             * This is the equivalent of the Web / page for your own user, or the profile page for a third party.<br>
//             * For backwards compatibility reasons, retweets are stripped out of the user_timeline when calling in XML or JSON (they appear with 'RT' in RSS and Atom). If you'd like them included, you can merge them in from statuses retweeted_by_me.<br>
//             * <br>This method calls https://api.twitter.com/1.1/statuses/user_timeline
//             *
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return the 20 most recent statuses posted in the last 24 hours from the user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/user_timeline">GET statuses/user_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses, including retweets, posted by the authenticating user and that user's friends. This is the equivalent of /timeline/home on the Web.<br>
//             * Usage note: This home_timeline call is identical to statuses/friends_timeline, except that home_timeline also contains retweets, while statuses/friends_timeline does not for backwards compatibility reasons. In a future version of the API, statuses/friends_timeline will be deprected and replaced by home_timeline.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/home_timeline
//             *
//             * @return list of the home Timeline
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/home_timeline">GET statuses/home_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public ResponseList<Status> getHomeTimeline() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent statuses, including retweets, posted by the authenticating user and that user's friends. This is the equivalent of /timeline/home on the Web.<br>
//             * Usage note: This home_timeline call is identical to statuses/friends_timeline, except that home_timeline also contains retweets, while statuses/friends_timeline does not for backwards compatibility reasons. In a future version of the API, statuses/friends_timeline will be deprected and replaced by home_timeline.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/home_timeline
//             *
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of the home Timeline
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/home_timeline">GET statuses/home_timeline | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent tweets of the authenticated user that have been retweeted by others.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/retweets_of_me.json
//             *
//             * @return the 20 most recent tweets of the authenticated user that have been retweeted by others.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/retweets_of_me">GET statuses/retweets_of_me | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent tweets of the authenticated user that have been retweeted by others.
//             * <br>This method calls https://api.twitter.com/1.1/statuses/retweets_of_me.json
//             *
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return the 20 most recent tweets of the authenticated user that have been retweeted by others.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/statuses/retweets_of_me">GET statuses/retweets_of_me | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Access the users in a given category of the Twitter suggested user list.<br>
//             * It is recommended that end clients cache this data for no more than one hour.
//             * <br>This method calls https://api.twitter.com/1.1/users/suggestions/:slug.json
//             *
//             * @param categorySlug slug
//             * @return list of suggested users
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/suggestions/:slug">GET users/suggestions/:slug | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Access to Twitter's suggested user list. This returns the list of suggested user categories. The category can be used in the users/suggestions/category endpoint to get the users in that category.
//             * <br>This method calls https://api.twitter.com/1.1/users/suggestions
//             *
//             * @return list of suggested user categories.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/suggestions">GET users/suggestions | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Access the users in a given category of the Twitter suggested user list and return their most recent status if they are not a protected user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/users/suggestions/:slug/members.json
//             *
//             * @param categorySlug slug
//             * @return list of suggested users
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/users/suggestions/%3Aslug/members">GET users/suggestions/:slug/members | Twitter Developers</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public ResponseList<User> getMemberSuggestions(String categorySlug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * The user specified in the id is blocked by the authenticated user and reported as a spammer.
//             * <br>This method calls https://api.twitter.com/1.1/report_spam.json
//             *
//             * @param userId The ID of the user you want to report as a spammer.
//             * @return The User reported as a spammer.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/report_spam">POST report_spam | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User reportSpam(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * The user specified in the id is blocked by the authenticated user and reported as a spammer.
//             * <br>This method calls https://api.twitter.com/1.1/report_spam.json
//             *
//             * @param screenName The screen name of the user you want to report as a spammer.
//             * @return The User reported as a spammer.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/report_spam">POST report_spam | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User reportSpam(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns tweets that match a specified query.
//             * <br>This method calls http://search.twitter.com/search.json
//             *
//             * @param query - the search condition
//             * @return the result
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/search">GET search | Twitter Developers</a>
//             * @see <a href="http://search.twitter.com/operators">Twitter API / Search Operators</a>
//             * @since Twitter4J 1.1.7
//             */
//            @Override
//            public QueryResult search(Query query) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the authenticated user's saved search queries.
//             * <br>This method calls https://api.twitter.com/1.1/saved_searches.json
//             *
//             * @return Returns an array of numeric user ids the authenticating user is blocking.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/saved_searches">GET saved_searches | Twitter Developers</a>
//             * @since Twitter4J 2.0.8
//             */
//            @Override
//            public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Retrieve the data for a saved search owned by the authenticating user specified by the given id.
//             * <br>This method calls https://api.twitter.com/1.1/saved_searches/show/:id.json
//             *
//             * @param id The id of the saved search to be retrieved.
//             * @return the data for a saved search
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/saved_searches/show/:id">GET saved_searches/show/:id | Twitter Developers</a>
//             * @since Twitter4J 2.0.8
//             */
//            @Override
//            public SavedSearch showSavedSearch(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Creates a saved search for the authenticated user.
//             * <br>This method calls https://api.twitter.com/1.1/saved_searches/saved_searches/create.json
//             *
//             * @param query the query string
//             * @return the data for a created saved search
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/saved_searches/create">POST saved_searches/create | Twitter Developers</a>
//             * @since Twitter4J 2.0.8
//             */
//            @Override
//            public SavedSearch createSavedSearch(String query) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Destroys a saved search for the authenticated user. The search specified by id must be owned by the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/saved_searches/destroy/id.json
//             *
//             * @param id The id of the saved search to be deleted.
//             * @return the data for a destroyed saved search
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/saved_searches/destroy/:id">POST saved_searches/destroy/:id | Twitter Developers</a>
//             * @since Twitter4J 2.0.8
//             */
//            @Override
//            public SavedSearch destroySavedSearch(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Find out more details of a place that was returned from the {@link PlacesGeoResources#reverseGeoCode(GeoQuery)} method.
//             * <br>This method calls https://api.twitter.com/1.1/geo/id/:id.json
//             *
//             * @param placeId The ID of the location to query about.
//             * @return details of the specified place
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/geo/id/:place_id">GET geo/id/:place_id | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public Place getGeoDetails(String placeId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Search for places (cities and neighborhoods) that can be attached to a statuses/update. Given a latitude and a longitude, return a list of all the valid places that can be used as a place_id when updating a status. Conceptually, a query can be made from the user's location, retrieve a list of places, have the user validate the location he or she is at, and then send the ID of this location up with a call to statuses/update.<br>
//             * There are multiple granularities of places that can be returned -- "neighborhoods", "cities", etc. At this time, only United States data is available through this method.<br>
//             * This API call is meant to be an informative call and will deliver generalized results about geography.
//             * <br>This method calls https://api.twitter.com/1.1/geo/reverse_geocode.json
//             *
//             * @param query search query
//             * @return places (cities and neighborhoods) that can be attached to a statuses/update
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/geo/reverse_geocode">GET geo/reverse_geocode | Twitter Developers</a>
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public ResponseList<Place> reverseGeoCode(GeoQuery query) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Search for places that can be attached to a statuses/update. Given a latitude and a longitude pair, an IP address, or a name, this request will return a list of all the valid places that can be used as the place_id when updating a status.
//             * <br>Conceptually, a query can be made from the user's location, retrieve a list of places, have the user validate the location he or she is at, and then send the ID of this location with a call to statuses/update.
//             * <br>This is the recommended method to use find places that can be attached to statuses/update. Unlike geo/reverse_geocode which provides raw data access, this endpoint can potentially re-order places with regards to the user who is authenticated. This approach is also preferred for interactive place matching with the user.
//             * <br>This method calls https://api.twitter.com/1.1/geo/search.json
//             *
//             * @param query search query
//             * @return places (cities and neighborhoods) that can be attached to a statuses/update
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/geo/search">GET geo/search | Twitter Developers</a>
//             * @since Twitter4J 2.1.7
//             */
//            @Override
//            public ResponseList<Place> searchPlaces(GeoQuery query) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Locates places near the given coordinates which are similar in name.
//             * <br>Conceptually you would use this method to get a list of known places to choose from first. Then, if the desired place doesn't exist, make a request to post/geo/place to create a new one.
//             * <br>The token contained in the response is the token needed to be able to create a new place.
//             * <br>This method calls https://api.twitter.com/1.1/geo/similar_places.json
//             *
//             * @param location        The latitude and longitude to search around.
//             * @param name            The name a place is known as.
//             * @param containedWithin optional: the place_id which you would like to restrict the search results to. Setting this value means only places within the given place_id will be found.
//             * @param streetAddress   optional: This parameter searches for places which have this given street address. There are other well-known, and application specific attributes available. Custom attributes are also permitted. Learn more about Place Attributes.
//             * @return places (cities and neighborhoods) that can be attached to a statuses/update
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 2.1.7
//             */
//            @Override
//            public ResponseList<Place> getSimilarPlaces(GeoLocation location, String name, String containedWithin, String streetAddress) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists of the specified user. Private lists will be included if the authenticated users is the same as the user whose lists are being returned.
//             * <br>This method calls https://api.twitter.com/1.1/lists.json
//             *
//             * @param listOwnerScreenName The screen name of the list owner
//             *                            as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/list">GET lists/list | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public ResponseList<UserList> getUserLists(String listOwnerScreenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists of the specified user. Private lists will be included if the authenticated users is the same as the user whose lists are being returned.
//             * <br>This method calls https://api.twitter.com/1.1/lists.json
//             *
//             * @param listOwnerScreenName The screen name of the list owner
//             *                            as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param reverse             Set this to true if you would like owned lists to be returned first
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/list">GET lists/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public ResponseList<UserList> getUserLists(String listOwnerScreenName, boolean reverse) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists of the specified user. Private lists will be included if the authenticated users is the same as the user whose lists are being returned.
//             * <br>This method calls https://api.twitter.com/1.1/lists.json
//             *
//             * @param listOwnerUserId The id of the list owner
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/list">GET lists/list | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public ResponseList<UserList> getUserLists(long listOwnerUserId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists of the specified user. Private lists will be included if the authenticated users is the same as the user whose lists are being returned.
//             * <br>This method calls https://api.twitter.com/1.1/lists.json
//             *
//             * @param listOwnerUserId The id of the list owner
//             * @param reverse         Set this to true if you would like owned lists to be returned first
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/list">GET lists/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public ResponseList<UserList> getUserLists(long listOwnerUserId, boolean reverse) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show tweet timeline for members of the specified list.
//             * <br>https://api.twitter.com/1/user/lists/list_id/statuses.json
//             *
//             * @param listId The id of the list
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of statuses for members of the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/statuses">GET lists/statuses | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public ResponseList<Status> getUserListStatuses(long listId, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show tweet timeline for members of the specified list.
//             * <br>https://api.twitter.com/1/user/lists/list_id/statuses.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param paging  controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of statuses for members of the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/statuses">GET lists/statuses | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<Status> getUserListStatuses(long ownerId, String slug, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show tweet timeline for members of the specified list.
//             * <br>https://api.twitter.com/1.1/lists/statuses.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param paging          controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return list of statuses for members of the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/statuses">GET lists/statuses | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public ResponseList<Status> getUserListStatuses(String ownerScreenName, String slug, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified member from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy.json
//             *
//             * @param listId The id of the list.
//             * @param userId The screen name of the member you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy">POST lists/members/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public UserList destroyUserListMember(long listId, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified members from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy.json
//             *
//             * @param listId     The id of the list.
//             * @param screenName The screen name of the member you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy">POST lists/members/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public UserList destroyUserListMember(long listId, String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified members from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy_all.json
//             *
//             * @param listId      The id of the list.
//             * @param screenNames The screen names of the members you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy_all">POST lists/members/destroy_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public UserList destroyUserListMembers(long listId, String[] screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified members from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy_all.json
//             *
//             * @param listId  The id of the list.
//             * @param userIds The array of ids of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy_all">POST lists/members/destroy_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public UserList destroyUserListMembers(long listId, long[] userIds) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified members from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy_all.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param screenNames     The screen names of the members you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy_all">POST lists/members/destroy_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public UserList destroyUserListMembers(String ownerScreenName, String slug, String[] screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified member from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param userId  The screen name of the member you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy">POST lists/members/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList destroyUserListMember(long ownerId, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Removes the specified member from the list. The authenticated user must be the list's owner to remove members from the list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/destroy.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param userId          The screen name of the member you wish to remove from the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/destroy">POST lists/members/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList destroyUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the authenticating user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the authenticating user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param count  The amount of results to return per page. No more than 1000 results will ever be returned in a single page.
//             * @param cursor Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberId The id of the list member
//             * @param cursor       Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberId The id of the list member
//             * @param count        The amount of results to return per page. No more than 1000 results will ever be returned in a single page.
//             * @param cursor       Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberScreenName The screen name of the list member
//             * @param cursor               Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberScreenName The screen name of the list member
//             * @param count                The amount of results to return per page. No more than 1000 results will ever be returned in a single page.
//             * @param cursor               Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberScreenName The screen name of the list member
//             * @param cursor               Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param filterToOwnedLists   Whether to return just lists the authenticating user owns, and the user represented by listMemberScreenName is a member of.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when filerToOwnedLists is true but authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor, boolean filterToOwnedLists) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberScreenName The screen name of the list member
//             * @param count                The amount of results to return per page. No more than 1000 results will ever be returned in a single page.
//             * @param cursor               Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param filterToOwnedLists   Whether to return just lists the authenticating user owns, and the user represented by listMemberScreenName is a member of.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when filerToOwnedLists is true but authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberId       The id of the list member
//             * @param cursor             Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param filterToOwnedLists Whether to return just lists the authenticating user owns, and the user represented by listMemberId is a member of.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when filerToOwnedLists is true but authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor, boolean filterToOwnedLists) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user has been added to.
//             * <br>This method calls https://api.twitter.com/1.1/lists/memberships.json
//             *
//             * @param listMemberId       The id of the list member
//             * @param count              The amount of results to return per page. No more than 1000 results will ever be returned in a single page.
//             * @param cursor             Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param filterToOwnedLists Whether to return just lists the authenticating user owns, and the user represented by listMemberId is a member of.
//             * @return the list of lists
//             * @throws TwitterException      when Twitter service or network is unavailable
//             * @throws IllegalStateException when filerToOwnedLists is true but authorization is not enabled
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/memberships">GET lists/memberships | Twitter Developers</a>
//             * @since Twitter4J 2.2.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param listId The id of the list
//             * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long listId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param listId The id of the list
//             * @param count  Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param listId     The id of the list
//             * @param count      Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor     Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param cursor  Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param count   Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor  Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerId    The user ID of the user who owns the list being requested by a slug.
//             * @param slug       slug of the list
//             * @param count      Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor     Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param count           Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the subscribers of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param count           Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus      When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers">GET lists/subscribers | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Make the authenticated user follow the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/list/subscribers/create.json
//             *
//             * @param listId The id of the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/create">POST lists/subscribers/create | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public UserList createUserListSubscription(long listId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Make the authenticated user follow the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/list/subscribers/create.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/create">POST lists/subscribers/create | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList createUserListSubscription(long ownerId, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Make the authenticated user follow the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/list/subscribers/create.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/create">POST lists/subscribers/create | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList createUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if the specified user is a subscriber of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers/show.json
//             *
//             * @param listId The id of the list.
//             * @param userId The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers/show">GET lists/subscribers/show | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public User showUserListSubscription(long listId, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if the specified user is a subscriber of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers/show.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param userId  The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers/show">GET lists/subscribers/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public User showUserListSubscription(long ownerId, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if the specified user is a subscriber of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscribers/show.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param userId          The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscribers/show">GET lists/subscribers/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public User showUserListSubscription(String ownerScreenName, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Unsubscribes the authenticated user form the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/subscribers/destroy.json
//             *
//             * @param listId The id of the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/destroy">POST lists/subscribers/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public UserList destroyUserListSubscription(long listId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Unsubscribes the authenticated user form the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/subscribers/destroy.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/destroy">POST lists/subscribers/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList destroyUserListSubscription(long ownerId, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Unsubscribes the authenticated user form the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/subscribers/destroy.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/subscribers/destroy">POST lists/subscribers/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList destroyUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param listId  The id of the list.
//             * @param userIds The array of ids of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList createUserListMembers(long listId, long... userIds) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param userIds The array of ids of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList createUserListMembers(long ownerId, String slug, long... userIds) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param userIds         The array of ids of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList createUserListMembers(String ownerScreenName, String slug, long... userIds) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param listId      The id of the list.
//             * @param screenNames The array of screen names of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 2.1.7
//             */
//            @Override
//            public UserList createUserListMembers(long listId, String... screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param ownerId     The user ID of the user who owns the list being requested by a slug.
//             * @param slug        slug of the list
//             * @param screenNames The array of screen names of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList createUserListMembers(long ownerId, String slug, String... screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds multiple members to a list, by specifying a comma-separated list of member ids or screen names. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members, and you are limited to adding up to 100 members to a list at a time with this method.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create_all.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param screenNames     The array of screen names of the user to add as member of the list. up to 100 are allowed in a single request.
//             * @return the list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create_all">POST lists/members/create_all | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList createUserListMembers(String ownerScreenName, String slug, String... screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if a user is a member of the specified list.<br>
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/show.json
//             *
//             * @param listId The id of the list.
//             * @param userId The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members/show">GET lists/members/show | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public User showUserListMembership(long listId, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if a user is a member of the specified list.<br>
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/show.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param userId  The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members/show">GET lists/members/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public User showUserListMembership(long ownerId, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Check if a user is a member of the specified list.<br>
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/show.json
//             *
//             * @param ownerScreenName Id The user ID of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param userId          The id of the user who you want to know is a member or not of the specified list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             *                          , or the user is not a member of the specified list(TwitterException.getStatusCode() returns 404 in that case.)
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members/show">GET lists/members/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public User showUserListMembership(String ownerScreenName, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param listId The id of the list
//             * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long listId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param listId The id of the list
//             * @param count  Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param listId     The id of the list
//             * @param count      Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor     Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param cursor  Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long ownerId, String slug, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param count   Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor  Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerId    The user ID of the user who owns the list being requested by a slug.
//             * @param slug       slug of the list
//             * @param count      Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor     Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param count           Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the members of the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param count           Specifies the number of results to return per page. The default is 20, with a maximum of 5,000.
//             * @param cursor          Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @param skipStatus      When set to either true, t or 1 statuses will not be included in the returned user objects.
//             * @return the members of the specified list.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/members">GET lists/members | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds a member to a list. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create.json
//             *
//             * @param listId The id of the list.
//             * @param userId The id of the user to add as a member of the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create">POST lists/members/create | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public UserList createUserListMember(long listId, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds a member to a list. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @param userId  The id of the user to add as a member of the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create">POST lists/members/create | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList createUserListMember(long ownerId, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Adds a member to a list. The authenticated user must own the list to be able to add members to it. Lists are limited to having 5000 members.
//             * <br>This method calls https://api.twitter.com/1.1/lists/members/create.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param userId          The id of the user to add as a member of the list.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/members/create">POST lists/members/create | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList createUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Deletes the specified list. Must be owned by the authenticated user.
//             * <br>This method calls https://api.twitter.com/1.1/lists/destroy.json
//             *
//             * @param listId The id of the list to delete
//             * @return the deleted list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/destroy">POST lists/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public UserList destroyUserList(long listId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Deletes the specified list. Must be owned by the authenticated user.
//             * <br>This method calls https://api.twitter.com/1.1/lists/destroy.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @return the deleted list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/destroy">POST lists/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList destroyUserList(long ownerId, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Deletes the specified list. Must be owned by the authenticated user.
//             * <br>This method calls https://api.twitter.com/1.1/lists/destroy.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @return the deleted list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/destroy">POST lists/destroy | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList destroyUserList(String ownerScreenName, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/update.json
//             *
//             * @param listId         The id of the list to update.
//             * @param newListName    What you'd like to change the list's name to.
//             * @param isPublicList   Whether your list is public or private. Optional. Values can be public or private. Lists are public by default if no mode is specified.
//             * @param newDescription What you'd like to change the list description to.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/update">POST lists/update | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public UserList updateUserList(long listId, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/update.json
//             *
//             * @param ownerId        The user ID of the user who owns the list being requested by a slug.
//             * @param slug           slug of the list
//             * @param newListName    What you'd like to change the list's name to.
//             * @param isPublicList   Whether your list is public or private. Optional. Values can be public or private. Lists are public by default if no mode is specified.
//             * @param newDescription What you'd like to change the list description to.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/update">POST lists/update | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList updateUserList(long ownerId, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Updates the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/update.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @param newListName     What you'd like to change the list's name to.
//             * @param isPublicList    Whether your list is public or private. Optional. Values can be public or private. Lists are public by default if no mode is specified.
//             * @param newDescription  What you'd like to change the list description to.
//             * @return the updated list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/update">POST lists/update | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList updateUserList(String ownerScreenName, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Creates a new list for the authenticated user. Accounts are limited to 20 lists.
//             * <br>This method calls https://api.twitter.com/1.1/lists/create.json
//             *
//             * @param listName     The name of the list you are creating. Required.
//             * @param isPublicList set true if you wish to make a public list
//             * @param description  The description of the list you are creating. Optional.
//             * @return the list that was created
//             * @throws TwitterException when Twitter service or network is unavailable, or the authenticated user already has 20 lists(TwitterException.getStatusCode() == 403).
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/lists/create">POST lists/create | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public UserList createUserList(String listName, boolean isPublicList, String description) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show the specified list. Private lists will only be shown if the authenticated user owns the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/show.json
//             *
//             * @param listId The id of the list to show
//             * @return the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/show">https://dev.twitter.com/docs/api/1.1/get/lists/show | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public UserList showUserList(long listId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show the specified list. Private lists will only be shown if the authenticated user owns the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/show.json
//             *
//             * @param ownerId The user ID of the user who owns the list being requested by a slug.
//             * @param slug    slug of the list
//             * @return the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/show">https://dev.twitter.com/docs/api/1.1/get/lists/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public UserList showUserList(long ownerId, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Show the specified list. Private lists will only be shown if the authenticated user owns the specified list.
//             * <br>This method calls https://api.twitter.com/1.1/lists/show.json
//             *
//             * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
//             * @param slug            slug of the list
//             * @return the specified list
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/show">https://dev.twitter.com/docs/api/1.1/get/lists/show | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public UserList showUserList(String ownerScreenName, String slug) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user follows.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscriptions.json
//             *
//             * @param listSubscriberScreenName The screen name of the list subscriber
//             * @param cursor                   Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists the specified user is subscribed to
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscriptions">GET lists/subscriptions | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user follows.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscriptions.json
//             *
//             * @param listSubscriberScreenName The screen name of the list subscriber
//             * @param count                    The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
//             * @param cursor                   Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists the specified user is subscribed to
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscriptions">GET lists/subscriptions | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user follows.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscriptions.json
//             *
//             * @param listSubscriberId The ID of the list subscriber
//             * @param cursor           Breaks the results into pages. A single page contains 20 lists. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists the specified user is subscribed to
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscriptions">GET lists/subscriptions | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * List the lists the specified user follows.
//             * <br>This method calls https://api.twitter.com/1.1/lists/subscriptions.json
//             *
//             * @param listSubscriberId The ID of the list subscriber
//             * @param count            The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
//             * @param cursor           Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned to in the response body's next_cursor and previous_cursor attributes to page back and forth in the list.
//             * @return the list of lists the specified user is subscribed to
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/lists/subscriptions">GET lists/subscriptions | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
//             * <br>This method calls https://api.twitter.com/1.1/lists/ownerships.json
//             *
//             * @param listOwnerScreenName The screen name of the list owner
//             * @param cursor              Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors</a> to navigate collections for more information.
//             * @return lists owned by the specified Twitter user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
//             * <br>This method calls https://api.twitter.com/1.1/lists/ownerships.json
//             *
//             * @param listOwnerScreenName The screen name of the list owner
//             * @param count               The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
//             * @param cursor              Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors</a> to navigate collections for more information.
//             * @return lists owned by the specified Twitter user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 4.0.1
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
//             * <br>This method calls https://api.twitter.com/1.1/lists/ownerships.json
//             *
//             * @param listOwnerId The id of the list owner
//             * @param cursor      Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors</a> to navigate collections for more information.
//             * @return lists owned by the specified Twitter user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
//             * <br>This method calls https://api.twitter.com/1.1/lists/ownerships.json
//             *
//             * @param listOwnerId The id of the list owner
//             * @param count       The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
//             * @param cursor      Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors</a> to navigate collections for more information.
//             * @return lists owned by the specified Twitter user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @since Twitter4J 4.0.1
//             */
//            @Override
//            public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, int count, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the current configuration used by Twitter including twitter.com slugs which are not usernames, maximum photo resolutions, and t.co URL lengths.<br>
//             * It is recommended applications request this endpoint when they are loaded, but no more than once a day.
//             *
//             * @return configuration
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/help/configuration">GET help/configuration | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the list of languages supported by Twitter along with their ISO 639-1 code. The ISO 639-1 code is the two letter value to use if you include lang with any of your requests.
//             *
//             * @return list of languages supported by Twitter
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/help/languages">GET help/languages | Twitter Developers</a>
//             * @since Twitter4J 2.2.3
//             */
//            @Override
//            public ResponseList<Language> getLanguages() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns Twitter's Privacy Policy.
//             * <br>This method calls https://api.twitter.com/1.1/help/privacy.json
//             *
//             * @return privacy policy
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/help/privacy">GET help/privacy | Twitter Developers</a>
//             * @since Twitter4J 2.1.7
//             */
//            @Override
//            public String getPrivacyPolicy() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns Twitter's' Terms of Service.
//             * <br>This method calls https://api.twitter.com/1.1/help/tos.json
//             *
//             * @return Terms of Service
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/help/tos">GET help/tos | Twitter Developers</a>
//             * @since Twitter4J 2.1.7
//             */
//            @Override
//            public String getTermsOfService() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the current rate limits for methods belonging to the specified resource families.<br>
//             * Each 1.1 API resource belongs to a "resource family" which is indicated in its method documentation. You can typically determine a method's resource family from the first component of the path after the resource version.<br>
//             * This method responds with a map of methods belonging to the families specified by the resources parameter, the current remaining uses for each of those resources within the current rate limiting window, and its expiration time in epoch time. It also includes a rate_limit_context field that indicates the current access token context.<br>
//             * You may also issue requests to this method without any parameters to receive a map of all rate limited GET methods. If your application only uses a few of methods, please explicitly provide a resources parameter with the specified resource families you work with.<br>
//             * Read more about REST API Rate Limiting in v1.1 and review the limits.<br>
//             * <br>This method calls https://api.twitter.com/1.1/application/rate_limit_status.json
//             *
//             * @return the rate limit statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/application/rate_limit_status">GET application/rate_limit_status</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the current rate limits for methods belonging to the specified resource families.<br>
//             * Each 1.1 API resource belongs to a "resource family" which is indicated in its method documentation. You can typically determine a method's resource family from the first component of the path after the resource version.<br>
//             * This method responds with a map of methods belonging to the families specified by the resources parameter, the current remaining uses for each of those resources within the current rate limiting window, and its expiration time in epoch time. It also includes a rate_limit_context field that indicates the current access token context.<br>
//             * You may also issue requests to this method without any parameters to receive a map of all rate limited GET methods. If your application only uses a few of methods, please explicitly provide a resources parameter with the specified resource families you work with.<br>
//             * Read more about REST API Rate Limiting in v1.1 and review the limits.<br>
//             * As of Nov 4th 2012, supported resource names are as follows:
//             * &quot;trends&quot;,&quot;application&quot;,&quot;users&quot;,&quot;saved_searches&quot;,&quot;geo&quot;,&quot;direct_messages&quot;,&quot;blocks&quot;,&quot;favorites&quot;,&quot;statuses&quot;,&quot;followers&quot;,&quot;help&quot;,&quot;friends&quot;,&quot;search&quot;,&quot;friendships&quot;,&quot;account&quot;,&quot;lists&quot;
//             * <br>This method calls https://api.twitter.com/1.1/application/rate_limit_status.json
//             *
//             * @param resources resources
//             * @return the rate limit statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/application/rate_limit_status">GET application/rate_limit_status</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public Map<String, RateLimitStatus> getRateLimitStatus(String... resources) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a collection of user IDs that the currently authenticated user does not want to receive retweets from.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/no_retweets/ids.json
//             *
//             * @return a collection of numeric IDs that the currently authenticated user does not want to receive retweets from.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friendships/no_retweets/ids">GET friendships/no_retweets/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getNoRetweetsFriendships() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the authenticating user is following.
//             * <br>This method calls https://api.twitter.com/1.1/friends/ids.json
//             *
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return an array of numeric IDs for every user the authenticating user is following
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/ids">GET friends/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFriendsIDs(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is following.
//             * <br>This method calls https://api.twitter.com/1.1/friends/ids.json
//             *
//             * @param userId Specifies the ID of the user for whom to return the friends list.
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return an array of numeric IDs for every user the specified user is following
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/ids">GET friends/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFriendsIDs(long userId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is following.
//             * <br>This method calls http://api.twitter.com/1.1/friends/ids.json
//             *
//             * @param userId Specifies the ID of the user for whom to return the friends list.
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @param count  Specifies the number of IDs attempt retrieval of, up to a maximum of 5,000 per distinct request. The value of count is best thought of as a limit to the number of results to return.<br>
//             *               When using the count parameter with this method, it is wise to use a consistent count value across all requests to the same user's collection.<br>
//             *               Usage of this parameter is encouraged in environments where all 5,000 IDs constitutes too large of a response.
//             * @return an array of numeric IDs for every user the specified user is following
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/ids">GET friends/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getFriendsIDs(long userId, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is following.
//             * <br>This method calls https://api.twitter.com/1.1/friends/ids.json
//             *
//             * @param screenName Specifies the screen name of the user for whom to return the friends list.
//             * @param cursor     Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *                   To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return an array of numeric IDs for every user the specified user is following
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/ids">GET friends/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFriendsIDs(String screenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is following.
//             * <br>This method calls http://api.twitter.com/1.1/friends/ids.json
//             *
//             * @param screenName Specifies the screen name of the user for whom to return the friends list.
//             * @param cursor     Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *                   To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @param count      Specifies the number of IDs attempt retrieval of, up to a maximum of 5,000 per distinct request. The value of count is best thought of as a limit to the number of results to return.<br>
//             *                   When using the count parameter with this method, it is wise to use a consistent count value across all requests to the same user's collection.<br>
//             *                   Usage of this parameter is encouraged in environments where all 5,000 IDs constitutes too large of a response.
//             * @return an array of numeric IDs for every user the specified user is following
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/ids">GET friends/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getFriendsIDs(String screenName, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is followed by.
//             * <br>This method calls https://api.twitter.com/1.1/followers/ids.json
//             *
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return The ID or screen_name of the user to retrieve the friends ID list for.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/ids">GET followers/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFollowersIDs(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is followed by.
//             * <br>This method calls https://api.twitter.com/1.1/followers/ids.json
//             *
//             * @param userId Specifies the ID of the user for whom to return the followers list.
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return The ID or screen_name of the user to retrieve the friends ID list for.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/ids">GET followers/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFollowersIDs(long userId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is followed by.
//             * <br>This method calls http://api.twitter.com/1.1/followers/ids.json
//             *
//             * @param userId Specifies the ID of the user for whom to return the followers list.
//             * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *               To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @param count  Specifies the number of IDs attempt retrieval of, up to a maximum of 5,000 per distinct request. <br>
//             *               The value of count is best thought of as a limit to the number of results to return. <br>
//             *               When using the count parameter with this method, it is wise to use a consistent count value across all requests to the same user's collection. Usage of this parameter is encouraged in environments where all 5,000 IDs constitutes too large of a response.
//             * @return The ID or screen_name of the user to retrieve the friends ID list for.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/ids">GET followers/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getFollowersIDs(long userId, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is followed by.
//             * <br>This method calls https://api.twitter.com/1.1/followers/ids.json
//             *
//             * @param screenName Specifies the screen name of the user for whom to return the followers list.
//             * @param cursor     Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *                   To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @return The ID or screen_name of the user to retrieve the friends ID list for.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/ids">GET followers/ids | Twitter Developers</a>
//             * @since Twitter4J 2.0.10
//             */
//            @Override
//            public IDs getFollowersIDs(String screenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user the specified user is followed by.
//             * <br>This method calls http://api.twitter.com/1.1/followers/ids.json
//             *
//             * @param screenName Specifies the screen name of the user for whom to return the followers list.
//             * @param cursor     Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. <br>
//             *                   To begin paging provide a value of -1 as the cursor. The response from the API will include a previous_cursor and next_cursor to allow paging back and forth.
//             * @param count      Specifies the number of IDs attempt retrieval of, up to a maximum of 5,000 per distinct request. <br>
//             *                   The value of count is best thought of as a limit to the number of results to return. <br>
//             *                   When using the count parameter with this method, it is wise to use a consistent count value across all requests to the same user's collection. Usage of this parameter is encouraged in environments where all 5,000 IDs constitutes too large of a response.
//             * @return The ID or screen_name of the user to retrieve the friends ID list for.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/ids">GET followers/ids | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public IDs getFollowersIDs(String screenName, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the relationship of the authenticating user to the specified users.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/lookup.json
//             *
//             * @param ids array of the ids to lookup
//             * @return list of Relationships
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="http://groups.google.com/group/twitter-api-announce/msg/34909da7c399169e">#newtwitter and the API - Twitter API Announcements | Google Group</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public ResponseList<Friendship> lookupFriendships(long... ids) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the relationship of the authenticating user to the specified users.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/lookup.json
//             *
//             * @param screenNames array of the screen names to lookup
//             * @return list of Relationships
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="http://groups.google.com/group/twitter-api-announce/msg/34909da7c399169e">#newtwitter and the API - Twitter API Announcements | Google Group</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public ResponseList<Friendship> lookupFriendships(String... screenNames) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every user who has a pending request to follow the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/incoming.json
//             *
//             * @param cursor Breaks the results into pages. A single page contains 5000 identifiers. Provide a value of -1 to begin paging.
//             * @return an array of numeric IDs for every user who has a pending request to follow the authenticating user.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friendships/incoming">GET friendships/incoming | Twitter Developers</a>
//             * @since Twitter4J 2.1.2
//             */
//            @Override
//            public IDs getIncomingFriendships(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns an array of numeric IDs for every protected user for whom the authenticating user has a pending follow request.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/outgoing.json
//             *
//             * @param cursor Breaks the results into pages. A single page contains 5000 identifiers. Provide a value of -1 to begin paging.
//             * @return an array of numeric IDs for every protected user for whom the authenticating user has a pending follow request.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friendships/outgoing">GET friendships/outgoing | Twitter Developers</a>
//             * @since Twitter4J 2.1.2
//             */
//            @Override
//            public IDs getOutgoingFriendships(long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to follow the user specified in the ID parameter.<br>
//             * Returns the befriended user in the requested format when successful. Returns a string describing the failure condition when unsuccessful. If you are already friends with the user an HTTP 403 will be returned.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/create/[id].json
//             *
//             * @param userId the ID of the user to be befriended
//             * @return the befriended user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/create">POST friendships/create | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User createFriendship(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to follow the user specified in the ID parameter.<br>
//             * Returns the befriended user in the requested format when successful. Returns a string describing the failure condition when unsuccessful. If you are already friends with the user an HTTP 403 will be returned.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/create/[id].json
//             *
//             * @param screenName the screen name of the user to be befriended
//             * @return the befriended user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/create">POST friendships/create | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public User createFriendship(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to follow the user specified in the ID parameter.<br>
//             * Returns the befriended user in the requested format when successful. Returns a string describing the failure condition when unsuccessful. If you are already friends with the user an HTTP 403 will be returned.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/create/[id].json
//             *
//             * @param userId the ID of the user to be befriended
//             * @param follow Enable notifications for the target user in addition to becoming friends.
//             * @return the befriended user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/create">POST friendships/create | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User createFriendship(long userId, boolean follow) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to follow the user specified in the ID parameter.<br>
//             * Returns the befriended user in the requested format when successful. Returns a string describing the failure condition when unsuccessful. If you are already friends with the user an HTTP 403 will be returned.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/create/[id].json
//             *
//             * @param screenName the screen name of the user to be befriended
//             * @param follow     Enable notifications for the target user in addition to becoming friends.
//             * @return the befriended user
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/create">POST friendships/create | Twitter Developers</a>
//             * @since Twitter4J 2.0.2
//             */
//            @Override
//            public User createFriendship(String screenName, boolean follow) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to unfollow the user specified in the ID parameter.<br>
//             * Returns the unfollowed user in the requested format when successful. Returns a string describing the failure condition when unsuccessful.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/destroy/[id].json
//             *
//             * @param userId the ID of the user for whom to request a list of friends
//             * @return User
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/destroy">POST friendships/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public User destroyFriendship(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows the authenticating users to unfollow the user specified in the ID parameter.<br>
//             * Returns the unfollowed user in the requested format when successful. Returns a string describing the failure condition when unsuccessful.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/destroy/[id].json
//             *
//             * @param screenName the screen name of the user for whom to request a list of friends
//             * @return User
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/friendships/destroy">POST friendships/destroy | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public User destroyFriendship(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows you to enable or disable retweets and device notifications from the specified user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/update.json
//             *
//             * @param userId                   user id to update
//             * @param enableDeviceNotification set true to enable device notification
//             * @param retweets                 set true to enable retweets
//             * @return Relationship
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="http://groups.google.com/group/twitter-api-announce/msg/34909da7c399169e">#newtwitter and the API - Twitter API Announcements | Google Group</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public Relationship updateFriendship(long userId, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Allows you to enable or disable retweets and device notifications from the specified user.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/update.json
//             *
//             * @param screenName               screen name to update
//             * @param enableDeviceNotification set true to enable device notification
//             * @param retweets                 set true to enable retweets
//             * @return Relationship
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="http://groups.google.com/group/twitter-api-announce/msg/34909da7c399169e">#newtwitter and the API - Twitter API Announcements | Google Group</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public Relationship updateFriendship(String screenName, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns detailed information about the relationship between two users.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/show.json
//             *
//             * @param sourceId the ID of the source user
//             * @param targetId the ID of the target user
//             * @return Relationship
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friendships/show">GET friendships/show | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public Relationship showFriendship(long sourceId, long targetId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns detailed information about the relationship between two users.
//             * <br>This method calls https://api.twitter.com/1.1/friendships/show.json
//             *
//             * @param sourceScreenName the screen name of the source user
//             * @param targetScreenName the screen name of the target user
//             * @return Relationship
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friendships/show">GET friendships/show | Twitter Developers</a>
//             * @since Twitter4J 2.1.0
//             */
//            @Override
//            public Relationship showFriendship(String sourceScreenName, String targetScreenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param userId The ID of the user for whom to return results for.
//             * @param cursor Causes the results to be broken into pages of no more than 20 records at a time.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(long userId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param userId The ID of the user for whom to return results for.
//             * @param cursor Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count  The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(long userId, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param screenName The screen name of the user for whom to return results for.
//             * @param cursor     Causes the results to be broken into pages of no more than 20 records at a time.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(String screenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param screenName The screen name of the user for whom to return results for.
//             * @param cursor     Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count      The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param userId              The ID of the user for whom to return results for.
//             * @param cursor              Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count               The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @param skipStatus          When set to either true, statuses will not be included in the returned user objects.
//             * @param includeUserEntities The user object entities node will be disincluded when set to false.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for every user the specified user is following (otherwise known as their "friends").<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/friends/list.json
//             *
//             * @param screenName          The screen name of the user for whom to return results for.
//             * @param cursor              Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count               The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @param skipStatus          When set to either true, statuses will not be included in the returned user objects.
//             * @param includeUserEntities The user object entities node will be disincluded when set to false.
//             * @return list of friends
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/friends/list">GET friends/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param userId The ID of the user for whom to return results for.
//             * @param cursor Causes the results to be broken into pages of no more than 20 records at a time.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(long userId, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param screenName The screen name of the user for whom to return results for.
//             * @param cursor     Causes the results to be broken into pages of no more than 20 records at a time.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(String screenName, long cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param userId The ID of the user for whom to return results for.
//             * @param cursor Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count  The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(long userId, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param screenName The screen name of the user for whom to return results for.
//             * @param cursor     Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count      The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param userId              The ID of the user for whom to return results for.
//             * @param cursor              Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count               The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @param skipStatus          When set to either true, statuses will not be included in the returned user objects.
//             * @param includeUserEntities The user object entities node will be disincluded when set to false.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a cursored collection of user objects for users following the specified user.<br>
//             * At this time, results are ordered with the most recent following first — however, this ordering is subject to unannounced change and eventual consistency issues. Results are given in groups of 20 users and multiple "pages" of results can be navigated through using the next_cursor value in subsequent requests. See <a href="https://dev.twitter.com/docs/misc/cursoring">Using cursors to navigate collections</a> for more information.
//             * <br>This method calls https://api.twitter.com/1.1/followers/list.json
//             *
//             * @param screenName          The screen name of the user for whom to return results for.
//             * @param cursor              Causes the results to be broken into pages of no more than 20 records at a time.
//             * @param count               The number of users to return per page, up to a maximum of 200. Defaults to 20.
//             * @param skipStatus          When set to either true, statuses will not be included in the returned user objects.
//             * @param includeUserEntities The user object entities node will be disincluded when set to false.
//             * @return list of followers
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/followers/list">GET followers/list | Twitter Developers</a>
//             * @since Twitter4J 4.0.2
//             */
//            @Override
//            public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             * <br>This method calls https://api.twitter.com/1.1/favorites.json
//             *
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public ResponseList<Status> getFavorites() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             *
//             * @param userId the id of the user for whom to request a list of favorite statuses
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<Status> getFavorites(long userId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             *
//             * @param screenName the screen name of the user for whom to request a list of favorite statuses
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public ResponseList<Status> getFavorites(String screenName) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             * <br>This method calls https://api.twitter.com/1.1/favorites.json
//             *
//             * @param paging controls pagination. Supports sinceId and page parameters.
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 2.2.5
//             */
//            @Override
//            public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             * <br>This method calls https://api.twitter.com/1.1/favorites/[id].json
//             *
//             * @param userId the id of the user for whom to request a list of favorite statuses
//             * @param paging controls pagination. Supports sinceId and page parameters.
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 3.0.0
//             */
//            @Override
//            public ResponseList<Status> getFavorites(long userId, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
//             * <br>This method calls https://api.twitter.com/1.1/favorites/[id].json
//             *
//             * @param screenName the screen name of the user for whom to request a list of favorite statuses
//             * @param paging     controls pagination. Supports sinceId and page parameters.
//             * @return favorite statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/favorites">GET favorites | Twitter Developers</a>
//             * @since Twitter4J 2.2.5
//             */
//            @Override
//            public ResponseList<Status> getFavorites(String screenName, Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Favorites the status specified in the ID parameter as the authenticating user.  Returns the favorite status when successful.
//             * <br>This method calls https://api.twitter.com/1.1/favorites/create/[id].json
//             *
//             * @param id the ID of the status to favorite
//             * @return created favorite status
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/favorites/create/:id">POST favorites/create/:id | Twitter Developers</a>
//             */
//            @Override
//            public Status createFavorite(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Un-favorites the status specified in the ID parameter as the authenticating user.  Returns the un-favorited status in the requested format when successful.
//             * <br>This method calls https://api.twitter.com/1.1/favorites/destroy/[id].json
//             *
//             * @param id the ID of the status to un-favorite
//             * @return destroyed statuses
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/post/favorites/destroy/:id">POST favorites/destroy/:id | Twitter Developers</a>
//             */
//            @Override
//            public Status destroyFavorite(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of the direct messages sent to the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages
//             *
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/direct_messages">GET direct_messages | Twitter Developers</a>
//             * @deprecated use {@link #getDirectMessages(int)} instead
//             */
//            @Override
//            public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of the direct messages sent to the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages
//             *
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/direct_messages">GET direct_messages | Twitter Developers</a>
//             * @deprecated use {@link #getDirectMessages(int)} instead
//             */
//            @Override
//            public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of the direct messages sent by the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/sent
//             *
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/direct_messages/sent">GET direct_messages/sent | Twitter Developers</a>
//             * @deprecated use {@link #getDirectMessages(int)} instead
//             */
//            @Override
//            public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a list of the direct messages sent by the authenticating user.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/sent
//             *
//             * @param paging controls pagination. Supports since_id, max_id, count and page parameters.
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/docs/api/1.1/get/direct_messages/sent">GET direct_messages/sent | Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             * @deprecated use {@link #getDirectMessages(int)} instead
//             */
//            @Override
//            public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns all Direct Message events (both sent and received) within the last 30 days. Sorted in reverse-chronological order.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/events/list.json
//             *
//             * @param count Max number of events to be returned. 20 default. 50 max.
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/list-events.html">GET direct_messages/events/list — Twitter Developers</a>
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public DirectMessageList getDirectMessages(int count) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns all Direct Message events (both sent and received) within the last 30 days. Sorted in reverse-chronological order.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/events/list.json
//             *
//             * @param count  Max number of events to be returned. 20 default. 50 max.
//             * @param cursor For paging through result sets greater than 1 page, use the “next_cursor” property from the previous request.
//             * @return List
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/list-events.html">GET direct_messages/events/list — Twitter Developers</a>
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public DirectMessageList getDirectMessages(int count, String cursor) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a single Direct Message event by the given id.
//             * <br>This method has not been finalized and the interface is subject to change in incompatible ways.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/events/show.json
//             *
//             * @param id message id
//             * @return DirectMessage
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="http://groups.google.com/group/twitter-api-announce/msg/34909da7c399169e">#newtwitter and the API - Twitter API Announcements | Google Group</a>
//             * @since Twitter4J 2.1.9
//             */
//            @Override
//            public DirectMessage showDirectMessage(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Deletes the direct message specified in the required ID parameter.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/events/destroy.json
//             *
//             * @param id The id of the Direct Message event that should be deleted.
//             * @return a dummy DirectMessage object. Starting from Twitter4J 4.0.7, all getters will throw IllegalStateException due to the API limitation. The return value will be changed to void in the furure release.
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/delete-message-event.html">DELETE direct_messages/events/destroy — Twitter Developers</a>
//             * @since Twitter4J 2.0.1
//             */
//            @Override
//            public DirectMessage destroyDirectMessage(long id) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sends a new direct message to the specified user from the authenticating user.  Requires both the user and text parameters below.
//             * The text will be trimmed if the length of the text is exceeding 140 characters.
//             * <br>This method calls https://dev.twitter.com/rest/reference/post/direct_messages/events/new
//             *
//             * @param userId the user id of the user to whom send the direct message
//             * @param text   The text of your direct message.
//             * @return DirectMessage
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/new-event">POST direct_messages/events/new (message_create) — Twitter Developers</a>
//             * @since Twitter4j 2.1.0
//             */
//            @Override
//            public DirectMessage sendDirectMessage(long userId, String text) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sends a new direct message to the specified user from the authenticating user.  Requires both the user and text parameters below.
//             * The text will be trimmed if the length of the text is exceeding 140 characters.
//             * <br>This method calls https://dev.twitter.com/rest/reference/post/direct_messages/events/new
//             *
//             * @param userId  the user id of the user to whom send the direct message
//             * @param text    The text of your direct message.
//             * @param mediaId id of media attachment
//             * @return DirectMessage
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/new-event">POST direct_messages/events/new (message_create) — Twitter Developers</a>
//             * @since Twitter4J 4.0.7
//             */
//            @Override
//            public DirectMessage sendDirectMessage(long userId, String text, long mediaId) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Sends a new direct message to the specified user from the authenticating user.  Requires both the user and text parameters below.
//             * The text will be trimmed if the length of the text is exceeding 140 characters.
//             * <br>This method calls https://api.twitter.com/1.1/direct_messages/new
//             *
//             * @param screenName the screen name of the user to whom send the direct message
//             * @param text       The text of your direct message.
//             * @return DirectMessage
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://developer.twitter.com/en/docs/direct-messages/sending-and-receiving/api-reference/new-event">POST direct_messages/events/new (message_create) — Twitter Developers</a>
//             */
//            @Override
//            public DirectMessage sendDirectMessage(String screenName, String text) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns a stream of the image included in direct messages.
//             *
//             * @param url image url
//             * @return InputStream
//             * @throws TwitterException when Twitter service or network is unavailable
//             * @see <a href="https://dev.twitter.com/discussions/24255">Access media shared in direct messages | Twitter Developers</a>
//             * @since Twitter4J 3.0.6
//             */
//            @Override
//            public InputStream getDMImageAsStream(String url) throws TwitterException {
//                return null;
//            }
//
//            /**
//             * Returns authenticating user's screen name.<br>
//             * This method may internally call verifyCredentials() on the first invocation if<br>
//             * - this instance is authenticated by Basic and email address is supplied instead of screen name, or
//             * - this instance is authenticated by OAuth.<br>
//             * Note that this method returns a transiently cached (will be lost upon serialization) screen name while it is possible to change a user's screen name.<br>
//             *
//             * @return the authenticating screen name
//             * @throws TwitterException      when verifyCredentials threw an exception.
//             * @throws IllegalStateException if no credentials are supplied. i.e.) this is an anonymous Twitter instance
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public String getScreenName() throws TwitterException, IllegalStateException {
//                return null;
//            }
//
//            /**
//             * Returns authenticating user's user id.<br>
//             * This method may internally call verifyCredentials() on the first invocation if<br>
//             * - this instance is authenticated by Basic and email address is supplied instead of screen name, or
//             * - this instance is authenticated by OAuth.<br>
//             *
//             * @return the authenticating user's id
//             * @throws TwitterException      when verifyCredentials threw an exception.
//             * @throws IllegalStateException if no credentials are supplied. i.e.) this is an anonymous Twitter instance
//             * @since Twitter4J 2.1.1
//             */
//            @Override
//            public long getId() throws TwitterException, IllegalStateException {
//                return 0;
//            }
//
//            /**
//             * Registers a RateLimitStatusListener for account associated rate limits
//             *
//             * @param listener the listener to be added
//             * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
//             * @since Twitter4J 2.1.12
//             */
//            @Override
//            public void addRateLimitStatusListener(RateLimitStatusListener listener) {
//
//            }
//
//            /**
//             * Registers a lambda action for account associated rate limits
//             *
//             * @param action the action to be added
//             * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public void onRateLimitStatus(Consumer<RateLimitStatusEvent> action) {
//
//            }
//
//            /**
//             * Registers a RateLimitStatusListener for account associated rate limits
//             *
//             * @param action the action to be added
//             * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
//             * @since Twitter4J 4.0.4
//             */
//            @Override
//            public void onRateLimitReached(Consumer<RateLimitStatusEvent> action) {
//
//            }
//
//            /**
//             * Returns the authorization scheme for this instance.<br>
//             * The returned type will be either of BasicAuthorization, OAuthAuthorization, or NullAuthorization
//             *
//             * @return the authorization scheme for this instance
//             */
//            @Override
//            public Authorization getAuthorization() {
//                return null;
//            }
//
//            /**
//             * Returns the configuration associated with this instance
//             *
//             * @return configuration associated with this instance
//             * @since Twitter4J 2.1.8
//             */
//            @Override
//            public Configuration getConfiguration() {
//                return null;
//            }
//
//            /**
//             * @return {@link TimelinesResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public TimelinesResources timelines() {
//                return null;
//            }
//
//            /**
//             * @return {@link TweetsResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public TweetsResources tweets() {
//                return null;
//            }
//
//            /**
//             * @return {@link SearchResource}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public SearchResource search() {
//                return null;
//            }
//
//            /**
//             * @return {@link DirectMessagesResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public DirectMessagesResources directMessages() {
//                return null;
//            }
//
//            /**
//             * @return {@link FriendsFollowersResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public FriendsFollowersResources friendsFollowers() {
//                return null;
//            }
//
//            /**
//             * @return {@link UsersResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public UsersResources users() {
//                return null;
//            }
//
//            /**
//             * @return {@link SuggestedUsersResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public SuggestedUsersResources suggestedUsers() {
//                return null;
//            }
//
//            /**
//             * @return {@link FavoritesResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public FavoritesResources favorites() {
//                return null;
//            }
//
//            /**
//             * @return {@link ListsResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public ListsResources list() {
//                return null;
//            }
//
//            /**
//             * @return {@link SavedSearchesResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public SavedSearchesResources savedSearches() {
//                return null;
//            }
//
//            /**
//             * @return {@link PlacesGeoResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public PlacesGeoResources placesGeo() {
//                return null;
//            }
//
//            /**
//             * @return {@link TrendsResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public TrendsResources trends() {
//                return null;
//            }
//
//            /**
//             * @return {@link SpamReportingResource}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public SpamReportingResource spamReporting() {
//                return null;
//            }
//
//            /**
//             * @return {@link HelpResources}
//             * @since Twitter4J 3.0.4
//             */
//            @Override
//            public HelpResources help() {
//                return null;
//            }
//        };
//    }
//}
