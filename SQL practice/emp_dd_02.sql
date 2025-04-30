	-- Create Tables
CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100) NOT NULL
);

CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    dept_id INT,
    salary DECIMAL(10, 2),
    hire_date DATE,
    manager_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id),
    FOREIGN KEY (manager_id) REFERENCES Employees(emp_id)
);

CREATE TABLE Projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

CREATE TABLE EmployeeProjects (
    emp_id INT,
    project_id INT,
    PRIMARY KEY (emp_id, project_id),
    FOREIGN KEY (emp_id) REFERENCES Employees(emp_id),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);

-- Insert Data into Departments
INSERT INTO Departments VALUES (1, 'Engineering'), (2, 'Marketing'), (3, 'HR');

-- Insert Data into Employees
INSERT INTO Employees VALUES
(101, 'Alice', 1, 90000, '2020-01-15', NULL),
(102, 'Bob', 1, 85000, '2021-06-20', 101),
(103, 'Charlie', 2, 75000, '2022-03-25', 101),
(104, 'David', 3, 65000, '2023-07-11', 102),
(105, 'Eve', 1, 95000, '2019-09-30', NULL);

-- Insert Data into Projects
INSERT INTO Projects VALUES (201, 'Alpha', 1), (202, 'Beta', 2), (203, 'Gamma', 1);

-- Insert Data into EmployeeProjects
INSERT INTO EmployeeProjects VALUES
(101, 201), (102, 201), (103, 202), (104, 203), (105, 201), (105, 203);
