drop Procedure [dbo].[sp_hienNhanVien]
go

SET QUOTED_IDENTIFIER ON
go
SET ANSI_NULLS ON
go
create proc [dbo].[sp_hienNhanVien]
as
begin
select * from NHANVIEN
end
go
