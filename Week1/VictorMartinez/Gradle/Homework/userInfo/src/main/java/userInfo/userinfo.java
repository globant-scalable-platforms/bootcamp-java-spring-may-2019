package userInfo;

class userinfo extends DefaultTask{

        def userName = "Pepito Perez"
        def passWord = "1234"

        @TaskAction
        def newUser(){
                println "New USer"
        }

        String getUserName(){
        return userName;
        }

        String getPassWord(){
        return passWord;
        }
}


