
#BranchName=$1; # develop

# Pull branch
#git pull origin $BranchName

# Build Api Server
sudo systemctl stop tomcat
rm ROOT.war
rm -r ROOT
cp /home/thaolv@kaopiz.local/IdeaProjects/blog.service/target/blog_service-0.0.1-SNAPSHOT.war /opt/tomcat/webapps/ROOT.war
sudo systemctl start tomcat
