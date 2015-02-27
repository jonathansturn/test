#!/bin/bash
# 2010 Corey Garst

# Show data
#stewart="e0d100ed55c2dc9e"
#colbert="5b2eb3b0eb99f143"
# Which show to check for?
# showId=$stewart

#array=( "3922113" "3927429")


# URL to parse
 #url="http://www.showclix.com/event/3927429"
# Date to check for tickets
checkdate="December 16"
# Email to send notifications to
email="jonathansturn23@gmail.com"
email2="moviebeholder23@yahoo.com"
# Temp directory to write to
tmpdir="/tmp9"
tmpdir2="/tmp10"

# Do not modify code below



#n=0
while IFS=$' ' read -r -a myArray
do
 #echo "${myArray[0]}"
 #echo "${myArray[1]}"
 for i in "${myArray[0]}"
	do
		:
		url=$i
		echo "$url"
	done
  for i in "${myArray[1]}"
  	do
  		:
  		date=$i
  		#echo "$date"
  	done
  	for i in "${myArray[2]}"
  	do
  		:
  		vip=$i
  		#echo "$date"
  	done
 #echo "${myArray[0]}"


#while read line
#do
	#showId= "$line"
	#read -a words
	#url="${words[0]}"
	#date="${words[1]}"
#	echo "${words[1]}"
	#url="$line"
#((n++))
#	echo "$n"
#done <log8.txt
#if ("$vip" = "");then
curl $url | grep "taken place" > $tmpdir2/twcache
curl $url | grep "unavailable" > $tmpdir/twcache

if !(diff /dev/null $tmpdir/twcache > /dev/null); then
  #echo $(date) Tickets available on $checkdate, sending email
  #echo $(date) Tickets available on $date
  #python -mwebbrowser "$url"
  #osascript /Users/school/Library/Application\ Scripts/com.apple.mail/FedEx\ copy73.scpt
  echo $(date) No available tickets on $date $vip
  #mail -s "Tickets not detected on $checkdate" $email < $tmpdir/twcache
  #echo "http://www.thedailyshow.com/tickets" | mail -s "Tickets not detected on $checkdate" $email2 < $tmpdir/twcache
elif !(diff /dev/null $tmpdir2/twcache > /dev/null); then
	echo $(date) No available tickets on $date $vip
else
  #echo $(date) No available tickets on $showId
  echo $(date) Tickets available on $date
  python -mwebbrowser "$url"
  #osascript /Users/school/Library/Application\ Scripts/com.apple.mail/FedEx\ copy7.scpt
  #mail -s "Tickets detected on $checkdate!!" $email < $tmpdir/twcache
  #echo "http://www.thedailyshow.com/tickets" | mail -s "Tickets detected on $checkdate!!" $email2 < $tmpdir/twcache
fi


#fi
#rm -f $tmpdir/twcache
#done <log8.txt
#done

done < vip2.txt
#curl -v --header "X-API-Token: " https://api.showclix.com/Seller/19902/events > allout.txt 2>&1
