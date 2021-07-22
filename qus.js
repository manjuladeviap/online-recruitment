

const quiz=[
{
q:' What is the output of the below code snippet?<br>#include<stdio.h><br>main()<br>{<br>   int a = 5, b = 3, c = 4; <br>   printf(<q>a = %d, b = %d\n</q>, a, b, c);<br> }',
options:['a=5,b=3','a=5,b=3,c=0','a=5,b=3,0','Compile error'],
answer:0
},
{
q:'Which operator is used to continue the definition of macro in the next line?',
options:['#','##','$','/'],
answer:3
},
{
q:'What is the output of the below code snippet.<br>#include<stdio.h><br>main()<br>{<br>   printf(<q>%d</q>, -11%2); <br>}',
options:['1' , '-1' , '5.5' , '-5.5'] ,
answer:1
},
{
q:'What is the output of the following statement?<br>#include<stdio.h><br>main()<br>{<br>   printf(<q>%d</q>, !0<2);<br>}',
options:['0' , '1' , 'False' , 'True'],
answer:1
},
{
q:'Similarity between a structure, union and enumeration,',
options:['All are helpful in defining new variables' , 'All are helpful in defining new data types', 'All are helpful in defining new pointers' , 'All are helpful in defining new structures'],
answer:1
},
{
q:'Predict the output of the following code segment:<br>// Add stdio.h header file in below code<br>int main()<br>{<br>int array[10] = {3, 0, 8, 1, 12, 8, 9, 2, 13, 10};<br>int x,y, z;<br>x = ++array[2];<br>y = array[2]++;<br>z = array[x++];<br>printf(<q>%d %d %d</q>, x, y, z);<br>return 0;<br>}',
options:['10 9 10' , '9 10 9' , '9 9 10 ' , 'None of the above ' ],
answer:0
},
{
q:'In the declaration given below, what is <q>array</q>?<br>int array[20];',
options:['Keyword' , 'Identifier' , 'Literal' , 'Operator'],
answer:1
},
{
q:'Which of the following is treated as a real number by default?',
options:['float' , 'long' , 'double' , 'long double' ],
answer:2
},
{
q:'Predict the output of the following code segment:<br>// Add stdio.h and stdbool.h header files in below code<br>int main()<br>{<br>bool arr[10] = { true, false };<br>printf(<q>ld\n</q>,sizeof(bool) );<br>return 0;<br>}',
options:['2' , '1' , '4' , '10'],
answer:1
},
{
q:'Predict the output of the following code segment:<br>// Add stdio.h header file in below code<br>int main()<br>{<br>const int limit = 10;<br>limit++;<br>printf(<q>%d</q>, limit);<br>return 0;<br>}',
options:['Compile error','10' ,'11' , '0'],
answer:0
}
]