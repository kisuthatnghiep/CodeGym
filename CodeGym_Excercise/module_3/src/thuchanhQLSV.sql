use quanlisinhvien;
select * from subject
where Credit < 10;
select s.studentID,s.studentName,c.className from student s join class c on s.ClassID = c.ClassID
where className = 'A1';
select s.studentID, s.studentName, sub.subName, M.mark from student s join Mark M on s.StudentID = M.StudentID join Subject sub on M.SubID = sub.subid;
select s.studentID, s.studentName, sub.subName, M.mark
from student s join Mark M on s.StudentID = M.StudentID join Subject sub on M.SubID = sub.subid
where subname = 'cf';