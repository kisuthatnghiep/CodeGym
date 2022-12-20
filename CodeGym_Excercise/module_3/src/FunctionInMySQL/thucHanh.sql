use quanlisinhvien;
select address, count(StudentID) as 'Student Number' from student
group by address;
insert into student(studentname, address, phone, status, classid) values
('Chiến', 'Ha Noi', 0395566479, 1, 1);
Select Student.studentId, student.studentName, avg(mark) as 'Average grade' from student
join mark on student.StudentID = mark.studentID
group by student.studentID
having avg(mark) > 15;
select * from student join mark on student.StudentID = mark.studentID;
insert into mark(subID, studentID, mark, examtimes) values
(2,2,26.2,1);
select Student.studentId, student.studentName, avg(mark) as 'Average grade' from student
join mark on student.StudentID = mark.studentID
group by student.studentID
having avg(mark) >= all(select avg(mark) from mark group by StudentID);