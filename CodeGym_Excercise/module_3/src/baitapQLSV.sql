use quanlisinhvien;
select * from student
 where StudentName like 'h%';
 select * from class
 where startDate like '%-12-%';
select * from subject
where Credit between 3 and 5;
update student set classid = 2 where studentname = 'hung';
select * from student;
select s.studentName, sub.subname, m.mark from student s
join mark m on s.StudentID = m.StudentID
join subject sub on sub.SubID = m.subid
order by mark desc,studentName asc;