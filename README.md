# Apparel store using servlets.

<img src="https://blog.almamaterstore.in/wp-content/uploads/2016/12/giphy-1.gif" >

An online apparel store using servlets. The store keeps records for its items in a database where some items may be discounted and some other items displayed as “new arrivals”. By default, when a user signs in, based on his/her profile (male/female etc.), he/she will see preferred set of clothing. Users will be divided into two groups: some users looking for discounted items mainly, some others looking for new arrivals. So, depending on their preference already set in the database, their shopping experience will be different.
I have used eclipse for the java-ee development purpose which is an integrated development environment (IDE) used in computer programming. It contains a base workspace and an extensible plug-in system for customizing the environment. And for the backend database purpose I have used MySQL and to JDBC I have used MySql Workbench and used session management. For the front-end purpose, I have used html and CSS for the webpage customization.
Database SQL code are `dbcode.txt` file


### Software Used : 
* Eclips IDE (Java 1.8)
* MySQL Workbench


### How to Run:

0. Open `ass4_online_apparel_store` in Ecliops IDE and 
1. Create table named `db` and execute SQL given in `dbcode.txt` file in MySql Workbench.
2. Goto `ass4_online_apparel_store/WebContent` and run `loginuser.jsp` file on server.

And bingo, the home page will be open like below:

<img src="https://github.com/mdsajjadansari/Apparel-Store-using-Servlet/blob/main/Screenshort/1.png">

### Features:
0. No more than one user
1. Forget password
2. Update user details (with password verification)
3. Show Preferences acconrding to type selected and gender.


Author : Md Sajjad Ansari
