set /p year=请输入年:
set /p mon=请输入月:
set /p day=请输入日:
java -classpath demo-1.0-SNAPSHOT-jar-with-dependencies.jar rongda.ReadExcel4 %cd% %year% %mon% %day%
pause