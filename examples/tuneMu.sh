#!/bin/bash
PROPPR="/home/krivard/git/rinkitink/ProPPR"
if [ -n "$1" ];
then
    PROPPR="$1"
fi

NAME="mu"
mkdir -p ${NAME}_tuning
for value in .0005 .005 .05 .00005 .00001; #.001 .01 .0001
do
    make clean.fast
    ./configure.sh --proppr $PROPPR --threads 3 --$NAME $value
    make
    for dataset in textcattoy top-1000-near-google webkb;
    do
        mv $dataset/results.txt ${NAME}_tuning/${dataset}_$value.txt
    done
done
echo "Done collecting data."
