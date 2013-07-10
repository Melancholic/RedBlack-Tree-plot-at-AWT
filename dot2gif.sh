#!/bin/bash
for i in $(ls ./img/*.dot); do  dot -Tpng $i -o $i.png;done;
echo "dot->png OK!";
echo "png converted...";
convert -gravity center -extent 3000X1600 ./img/*.png;
 echo "png converted OK!";
 echo "png->gif ...";
convert -delay 200  -loop 0 ./img/*-*.png   ./img/1.gif;
echo "OK!";

