# first argument is the server (qa/showcase) and second is the folder.war (eg birdsquare/CI).

scp -r artifacts/BirdSquare-1.0.war root@$1.birdsquare.in:/usr/local/jetty/webapps/$2.war
