
1 -maven clean
2 -maven install
3 -docker-compose build
4 -docker-compose up
5 -http://localhost:8080/load (access not allowed at first)
6 -
    a. http://localhost:8080/register/signup
    b. pass to the header (key: "Authorization", value: "mySecretKey")
    c. JSON
            {
            "username":"yourName",
            "email":"yourName@miu.edu",
            "password":"yourPassword",
            "role": ["admin"]
            }
    d. create a post request and send
7 -  
    a. http://localhost:8080/register/signin
    b. get your generated token

8 - 
    a. replace mySecretKey with the new generated token.
    b. send a get to http://localhost:8080/load.
    c. ITS DONE.
    



