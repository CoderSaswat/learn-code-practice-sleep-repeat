-- Project Table
CREATE TABLE Project (
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(100) NOT NULL,
    budget DECIMAL(15,2)
);
-- Department Table
CREATE TABLE Department (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(50) NOT NULL,
    location VARCHAR(100)
);
-- Employee Table
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_name VARCHAR(100) NOT NULL,
    department_id INT,
    salary DECIMAL(10,2),
    joining_date DATE,
    manager_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(dept_id),
    FOREIGN KEY (manager_id) REFERENCES Employee(emp_id)
);



-- Employee_Project (Many-to-Many)
CREATE TABLE Employee_Project (salary_history
    emp_id INT,
    project_id INT,
    role VARCHAR(50),
    PRIMARY KEY (emp_id, project_id),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id),
    FOREIGN KEY (project_id) REFERENCES Project(project_id)
);

-- Salary_History Table
CREATE TABLE Salary_History (
    emp_id INT,
    salary DECIMAL(10,2),
    changed_date DATE,
    PRIMARY KEY (emp_id, changed_date),
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);


-- Insert Departments
INSERT INTO Department (dept_name, location) VALUES
('HR', 'New York'),
('IT', 'San Francisco'),
('Finance', 'Chicago'),
('Marketing', 'Los Angeles'),
('Operations', 'Dallas');

-- Insert Employees
INSERT INTO Employee (emp_name, department_id, salary, joining_date, manager_id) VALUES
('Alice Johnson', 1, 60000, '2020-05-10', NULL),
('Bob Smith', 2, 75000, '2019-08-15', NULL),
('Charlie Brown', 2, 90000, '2018-03-20', 2),
('David Wilson', 3, 65000, '2021-07-01', NULL),
('Emma Thomas', 4, 72000, '2020-11-11', NULL),
('Frank White', 2, 85000, '2017-06-15', 2),
('Grace Lee', 3, 70000, '2019-09-30', 4),
('Hannah Baker', 1, 58000, '2022-01-05', 1);

-- Insert Projects
INSERT INTO Project (project_name, budget) VALUES
('Website Redesign', 100000),
('Cloud Migration', 200000),
('Financial Audit', 150000),
('Marketing Campaign', 120000),
('AI Implementation', 250000);

-- Assign Employees to Projects
INSERT INTO Employee_Project (emp_id, project_id, role) VALUES
(2, 1, 'Developer'),
(3, 1, 'Lead Developer'),
(5, 4, 'Marketing Specialist'),
(6, 2, 'Cloud Engineer'),
(7, 3, 'Financial Analyst'),
(8, 1, 'Designer'),
(1, 4, 'HR Consultant');

-- Insert Salary History
INSERT INTO Salary_History (emp_id, salary, changed_date) VALUES
(2, 70000, '2018-08-15'),
(2, 75000, '2019-08-15'),
(3, 85000, '2017-03-20'),
(3, 90000, '2018-03-20'),
(6, 80000, '2016-06-15'),
(6, 85000, '2017-06-15');
