class Customer {
    constructor() {
    }
        setName(name) {
            this.name = name;
        };
        getName() {
            return this.name
        };
        setCmnd(cmnd) {
            this.cmnd = cmnd;
        };
        getCmnd() {
            return this.cmnd
        };
        setBirthDay(birthDay) {
            this.birthDay = birthDay;
        };
        getBirthDay() {
            return this.birthDay
        };
        setEmail(email) {
            this.email = email;
        };
        getEmail() {
            return this.email
        };
       setAddress(address) {
            this.address = address;
        };
       getAddress() {
            return this.address
        };
       setTypeCustomer(typeCustomer) {
            this.typeCustomer = typeCustomer;
        };
        getTypeCustomer() {
            return this.typeCustomer
        };
       setDiscount(discount) {
            this.discount = discount;
        };
       getDiscount() {
            return this.discount
        };
       setPeople(people) {
            this.people = people;
        };
        getPeople() {
            return this.people
        };
        setRentDays(rentDays) {
            this.rentDays = rentDays;
        };
        getRentDays() {
            return this.rentDays
        };
        setTypeService(typeService) {
            this.typeService = typeService;
        };
        getTypeService() {
            return this.typeService
        };
        setTypeRoom(typeRoom) {
            this.typeRoom = typeRoom;
        };
        getTypeRoom() {
            return this.typeRoom
        };
        totaPays() {
            let money = 0;
            if (this.getTypeService() === "Villa") {
                money = 500;
            } else if (this.getTypeService() === "House") {
                money = 300;
            } else if (this.getTypeService() === "Room") {
                money = 200;
            }
            return this.getRentDays() * money * (1 - this.getDiscount() / 100);
        }
    }
