

# Hospital Management System

## Overview

The **Hospital Management System** is a Java-based application designed to facilitate the management of hospital operations. This system provides functionalities to manage patients and doctors, view records, and book appointments.

## Features

1. **Add Patients**: Allows users to add new patients to the system.
2. **View Patients**: Displays a list of all registered patients with their details.
3. **View Doctors**: Lists all doctors along with their specializations.
4. **Book Appointment**: Facilitates booking an appointment between a patient and a doctor on a specified date.

## Technologies Used

- **Java**: The programming language used for building the application.
- **MySQL**: The database used for storing patient and doctor information.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.

## Getting Started

To get started with this project, follow the steps below:

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/hospital-management-system.git
   cd hospital-management-system
   ```

2. **Set Up MySQL Database**

   - Create a MySQL database named `hospital`.
   - Use the provided SQL scripts to create necessary tables and populate initial data.

3. **Configure Database Connection**

   - Open the `Hospital_Management_Menu` class.
   - Update the `url`, `username`, and `password` fields with your MySQL database credentials.

4. **Compile and Run**

   - Compile the project using your preferred IDE or the command line.
   - Run the `Hospital_Management_Menu` class to start the application.

## Usage

- **Add Patients**: Choose option `1` from the main menu and enter the required patient details.
- **View Patients**: Choose option `2` to see the list of all patients.
- **View Doctors**: Choose option `3` to view the list of doctors.
- **Book Appointment**: Choose option `4` and provide patient ID, doctor ID, and appointment date to book an appointment.
- **Exit**: Choose option `5` to exit the application.

## Contributing

Feel free to submit pull requests or open issues if you have suggestions or find bugs.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- MySQL documentation and JDBC tutorial for database connectivity.
- Java community for the programming resources and support.

---

You can modify the placeholders like `yourusername` with your actual GitHub username or other details as needed.
