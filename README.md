# Employees Application
* ## Run Application
    * `mvn spring-boot:run`
* ## REST Service Operations

    * ### **Insertion of a new employee**
        * **URL:**
            * /employees/add
        * **Method:**
            * `POST`
        * **Data Parameters:**
            * `name: [String]`
            * `birthday: [Date]`
            * `address: [String]`
            * `status: [Status]`
                * `statusID: [Integer]`
                * `description: [String]`
            * `position: [Position]`
                * `positionID: [Integer]`
                * `description: [String]`
        * **Success Response:**
            * **Code:** 201 (Created)
            * **Content:** `Employee Object`
        * **Error Response:**
            * **Code:** 500 (Internal Server Error)



    * ### **Editing an existing employee**
        * **URL:**
            * /employees/edit/{id}
        * **Method:**
            * `PUT`
        * **Data Parameters (All Optional):**
            * `name: [String]`
            * `birthday: [Date]`
            * `address: [String]`
            * `status: [Status]`
                * `statusID: [Integer]`
                * `description: [String]`
            * `position: [Position]`
                * `positionID: [Integer]`
                * `description: [String]`
        * **Success Response:**
            * **Code:** 200 (OK)
            * **Content:** `Employee Object`
        * **Error Response:**
            * **Code:** 500 (Internal Server Error)
            * **Code:** 404 (Not Found)


    * ### **Removing a employee**
        * **URL:**
            * /employees/delete/{id}
        * **Method:**
            * `DELETE`
        * **Success Response:**
            * **Code:** 200 (OK)
            * **Content:** `Employee Successfully Removed`
        * **Error Response:**
            * **Code:** 500 (Internal Server Error)

    * ### **List of all employees**
        * **URL:**
            * /employees/getall
        * **Method:**
            * `GET`
        * **Success Response:**
            * **Code:** 200 (OK)
            * **Content:** `List of Employee Objects`
        * **Error Response:**
            * **Code:** 500 (Internal Server Error)

    * ### **Return of a specific employee**
        * **URL:**
            * /getemployee/{id}
        * **Method:**
            * `GET`
        * **Success Response:**
            * **Code:** 200 (OK)
            * **Content:** `Employee Object`
        * **Error Response:**
            * **Code:** 500 (Internal Server Error)
            * **Code:** 404 (Not Found)