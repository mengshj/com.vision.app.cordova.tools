var exec = require('cordova/exec');

module.exports = {
    onAppHide: function(success, error) {
        console.log('onAppHide()');
        exec(success, error, "Appoperate", "desktop", ['']);
    },

    onAppLogin: function(userName, pwd, success, error) {
        console.log('onAppLogin() - userName: ' + userName + ', pwd: ' + pwd);
        exec(success, error, "Appoperate", "login_ios", [userName, pwd]);
    }
};