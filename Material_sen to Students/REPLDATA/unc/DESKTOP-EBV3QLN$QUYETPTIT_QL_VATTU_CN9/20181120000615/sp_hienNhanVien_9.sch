drop Procedure [dbo].[sp_hienNhanVien]
go

SET QUOTED_IDENTIFIER ON
go
SET ANSI_NULLS ON
go

CREATE PROCEDURE [dbo].[sp_hienNhanVien]
AS
BEGIN
	select * from sinhvien
END

go
