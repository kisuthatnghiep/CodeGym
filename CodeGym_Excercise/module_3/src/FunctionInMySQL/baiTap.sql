use quanlisinhvien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
where credit >= all(select credit from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subject.*, mark.Mark from subject
join mark on subject.subID = Mark.subID
where mark.Mark >= all(select Mark from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.*, avg(mark) as 'Average Grade' from student
join mark on student.StudentID = mark. StudentID
group by StudentID;