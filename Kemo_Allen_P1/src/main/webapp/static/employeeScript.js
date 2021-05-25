document.getElementById('profile').onclick = getProfile;
document.getElementById('viewPending').onclick = getPending;// () calls fucnction without event
document.getElementById('viewResolved').onclick = getResolved;
document.getElementById('createForm').onclick = createForm;
document.getElementById('submitForm').onclick= submitForm;
document.getElementById('updateProfile').onclick= updateProfile;
document.getElementById('passwordBox').onclick = togglePassword;
document.getElementById('logoutButton').onclick = logout;

async function logout(){
    apiURL = 'http://localhost:8080/employee/logout';

    let response = await fetch(apiURL);
}

function togglePassword(){
    let p = document.getElementById("password");
    if(p.type === "password"){
        p.type ="text";
    } else{
        p.type = "password";
    }
}

async function submitForm(){
    apiURL = 'http://localhost:8080/employee/submitForm';
    // let reimb ={
    //     type: document.getElementById('type'),
    //     amount: document.getElementById('amount'),
    //     desc: document.getElementById('desc')
    // };

	// let response = await fetch(apiURL, {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json;charset=utf-8'
    //       },
    //       body: JSON.stringify(reimb)
    // });

    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        document.getElementById('body').innerHTML = `<p> Submitted Successfully </p>`
        
    }else{  
        document.getElementById('body').innerHTML = `<p> Error submitting reimbursement </p>`
    }
}

async function getProfile(){
    let apiURL = 'http://localhost:8080/employee/profile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayProfile(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error Profile. </p>`
    }
}

async function updateProfile(){
    let apiURL = 'http://localhost:8080/employee/updateProfile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        document.getElementById('body').innerHTML = `<p> Uodated Profile. </p>`
    }else{
        document.getElementById('body').innerHTML = `<p> Error Update Profile. </p>`
    }
}

async function getPending(){
    apiURL = 'http://localhost:8080/employee/viewPending';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimbP(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

async function getResolved(){
    apiURL = 'http://localhost:8080/employee/viewResolved';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimbR(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

function createForm(){
    let body = document.getElementById('body');
    body.innerHTML = ` 
    <form action="../employee/submitForm" method="POST">
        <h4>Enter Reimbursement Info </h4>
        <label for="type">Type</label>
        <select name="type" id="type" required>
            <option value="1">Lodging</option>
            <option value="2">Food</option>
            <option value="3">Other</option>
        </select>
        <br>
        <label for="amount">Amount: </label>
        <input type="number" id="amount" name="amount" class="form-control" min="0" max="10000" required>
        <label for="desc">Description:</label>
        <input type="text" id="desc" name="desc" class="form-control" maxlength="200">
        
        <button type ="submit" id="submitForm">Submit Reimbursement</button>
    </form>
    `
}

function displayProfile(response){
    document.getElementById('body').innerHTML =
    `<form action="../employee/updateProfile" method="POST">
        <p>User Id: ${response.id}</p>
        <p>User Name: ${response.userName}</p> 
        <label for="email">User Email: </label> 
        <input type="email" id="email" name="email"  value ="${response.email}" maxlength="150">
        <br>
        <label for="firstName">First Name: </label> 
        <input type="text" id="firstName" name="firstName" value="${response.firstName}" minlength="3" maxlength="100">
        <br>
        <label for="lastName">Last Name: </label> 
        <input type="text" id="lastName" name="lastName" value="${response.lastName}" minlength="3" maxlength="100">
        <br>
        <label for="password">Password: </label> 
        <input type="password" id="password" name="password" value="${response.password}" minlength="3" maxlength="50">
        <input type="checkbox" id="passwordBox">Show Password
        <br>
        <button type="submit" id="updateProfile">Update Profile</button>
     </form>
     `
}

function displayReimbP(response){
    let body = document.getElementById('body');
    let br = document.createElement('br');

    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} 
                        Status:  ${obj.reimbStatus} 
                        Amount:  ${obj.reimbAmount} 
                        Time Sent:  ${obj.reimbSubmitted} 
                        Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}

function displayReimbR(response){
    let body = document.getElementById('body');
    let br = document.createElement('br');

    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} 
                        Status:  ${obj.reimbStatus} 
                        Amount:  ${obj.reimbAmount} 
                        Time Sent:  ${obj.reimbSubmitted} 
                        Time Resolved:  ${obj.reimbResolved} 
                        Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}