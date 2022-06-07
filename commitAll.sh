 
cd ~/Git/r6-generator-runtime
git add -A
git commit -m "$1"
git push
cd ~/Git/r6-generator-maven-plugin
git add -A
git commit -m "$1"
git push
cd ~/Git/r6-generator-maven-plugin-test
git add -A
git commit -m "$1"
git push
cd ~/Git/r6-generator-maven-archetype
git add -A
git commit -m "$1"
git push
