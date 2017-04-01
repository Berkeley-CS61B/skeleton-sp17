#  Praject 2: Database System
## My goal
1. Finish the project on my own!!  
2. Write the doc for this project using javadoc tools.  
3. Using TDD way to test a single method once you have finish it.(Write Test VERY OFTEN!!!)  

==============================================================================
## My ideas for this project 
1. Learn from the client to the db package.(the relationship).  
2. Draw the big picture about this project.  
3. Implement the basic structure.  
4. Implement each faculty (test it more often).  

===============================================================================
## Learn from the client to the db package
**Find how to convert the method you write to client!!!!**.  
1. Using transact method to get a input which is a command, then return the result as string to the commond.  
2. Use the examples in the `Parse.java` to convert from input a commond to call a method.  

===============================================================================
## Write the big picture about the db.
1. Save all the table to the database.  
(1).  Use `Map<String, Table>` to save all the data used in the database.  
(2). Use `Table` to save a single table.  
  ------ Use the type `Map<String, ArrayList<Type>>` for a single table.  
2. Implement the commond needed for the database.  
(1). process in a single table:  
`insert into <table name> values <literal0>,<literal1>,...`.  
(2). process in the data base system:  
`create a table.`  
`load table`,  
`store table.`  
`print table.`  

===============================================================================
## Implement the interface needed for the data base system.
1. already implement the base function needed for this database system.  
2. Understand the class of `Parse.java` -- > build the conversion from commonds to call the methods in the database class.  
(I can only add all the silly code in the `Database.java`, which I think is stupid, but this is the only way I can do :( ).  
3. Evatually, I find a beatifull way to clean the ugly code by using the `extends` features. It would work because we think that Database class has the ability to convert commands to call functions.(That's exactly the `ParseCMD` do!!!!!!)  

===============================================================================
## Implement the actually code !!!!!
1. for `Database.java`.  
2. Find error in Create new commond.(The regular expression DONNOT match!!)  
3. 