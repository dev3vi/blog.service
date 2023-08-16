
#BranchName=$1; # develop

# Pull branch
#git pull origin $BranchName

# Build Api Server
sudo systemctl stop tomcat
rm blog.war
rm -r blog

cp /home/thaolv@kaopiz.local/IdeaProjects/blog.service/target/blog_service-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/blog.war
sudo systemctl start tomcat
