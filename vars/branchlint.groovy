#!/usr/bin/env groovy

def call() {
   sh '''#!/bin/bash
     a=${PROJECT_NAME}_${BRANCH_NAME}
     b=$(echo -n $a | wc -c)
     echo $a counts $b
     if [ $b -gt 32 ];then echo 'your project branch character combination exceeds the limit. Please keep the brnach name to 27 characters' && exit 1;fi
     if [[ !${BRANCH_NAME} =~ ^([0-9a-z-]+) ]]; then echo ${BRANCH_NAME} '--> Your branch has invalid characters.' && exit 1;fi
   '''
    
}
