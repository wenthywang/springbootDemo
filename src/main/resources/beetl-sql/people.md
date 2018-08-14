
        
updatePeople
===
*根据name获account
        
           update people set 
              name=#name#
              ,age=#age#
              ,updateTime=#updateTime#
              where id=#id#
              
insertPeople
===
*根据name获account
        
     insert into people  (name,age,id,insertTime) values (#name#,#age#,#id#,#insertTime#)