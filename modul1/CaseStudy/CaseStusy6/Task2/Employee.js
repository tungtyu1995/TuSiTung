class Employee {
    constructor() {
    }
    getName(){
        return this.name;
    }
    getBirthDay(){
        return this.birthDay;
    }
    getPhone(){
        return this.phone;
    }
    getEmail(){
        return this.email;
    }
    getCmnd(){
        return this.cmnd;
    }
    getLever(){
        return this.lever;
    }
    getLocation(){
        return this.location;
    }
    getSalary(){
        if(this.getLocation() === "Manager "){
            this.salary = 500;
        }else if (this.getLocation() === 'Sale'){
            this.salary = 300;
        }else if(this.getLocation() ==="Marketing"){
            this.salary = 200;
        }
        return this.salary
    }
    setName(name){
        this.name = name;
    }
    setCmnd(cmnd){
        this.cmnd = cmnd;
    }
    seBirthDay(birthDay){
        this.birthDay = birthDay;
    }
    setPhone(phone){
        this.phone = phone;
    }
    setEmail(email){
        this.email = email;
    }
    setLever(lever){
        this.lever = lever;
    }
    setLocation(location){
        this.location = location;
    }
}