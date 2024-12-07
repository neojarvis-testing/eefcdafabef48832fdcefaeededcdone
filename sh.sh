#!/usr/bin/bash
# To check the directory contains file
check_directory_empty() {
    local directory=$1
    local name=$2
    if [ -z "$(ls -A $directory)" ]; then
        echo $2 "-notexists"
    else
        echo $2 "-exists" 
    fi
}
# To check the directory contains file and the file has more than five lines of code
check_files() {
    min_lines=$1
    destination_dir=$2
    name=$3
    iteration=1  # Reset the iteration counter to 1

    for file in "$destination_dir"/*; do
        if [ -f "$file" ]; then
            # Count the lines in the file
            line_count=$(wc -l < "$file")
            if [ "$line_count" -gt "$min_lines" ]; then
                echo "$name-$iteration-exists"
            else
                echo "$name-$iteration-notexists"
            fi
            ((iteration++))  
        fi
    done
}


rm -rf /home/coder/project/workspace/Project/screenshot
rm -rf /home/coder/project/workspace/Project/logs
rm -rf /home/coder/project/workspace/Project/reports
rm -rf /home/coder/project/log.log
touch /home/coder/project/log.log
cp /home/coder/project/workspace/selenium/EventHandler.java /home/coder/project/workspace/Project/src/test/java/Utils/EventHandler.java
cd /home/coder/project/workspace/Project
cp /home/coder/project/workspace/selenium/EventHandleDummy.java /home/coder/project/workspace/Project/src/test/java/Utils/EventHandler.java
cat /home/coder/project/log.log

#Check for dir
logdir="/home/coder/project/workspace/Project/logs"
scrdir="/home/coder/project/workspace/Project/screenshot"
reportsdir="/home/coder/project/workspace/Project/reports"

check_directory_empty $logdir "log";
check_directory_empty $scrdir "scr";
check_directory_empty $reportsdir "report";

#chceck for files
PageFile="/home/coder/project/workspace/Project/src/test/java/Pages"
Uistore="/home/coder/project/workspace/Project/src/test/java/UiStore"
check_files 10 "$PageFile" "Pagefile"
check_files 5 "$Uistore" "UistoreFile"
