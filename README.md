# GaribKart

**#Rules for Creating feature branch from "dev"**

# Checkout the dev branch
git checkout dev

# pull latest code from dev
git pull origin dev

# Create a new feature branch
git checkout -b registration(it will directly create a new branch and switch to that branch)

your code...

# Now push the code to the dev branch.
1. git add .
2. git commit -m "message of what you did"
3. git push origin registration(if branch name is registration)

Merging the changes into the dev
1. git checkout dev
2. git pull origin dev
3. git merge registration(if branch name is registration from where you want to merge the code)
4. git push origin dev

Merge dev into uat:
Once the changes in dev are stable, they are merged into the uat branch for further testing.

# Checkout the uat branch
git checkout uat

# Pull the latest changes
git pull origin uat

# Merge the dev branch into uat
git merge dev

# Push the changes to the remote uat branch
git push origin uat



