def buildApp(){
    echo "build the app ..."
}

def testApp(){
    echo "test the app ..."
}

def deployingApp(){
    echo "deploying the application... with version ${params.VERSION}"
}

return this 