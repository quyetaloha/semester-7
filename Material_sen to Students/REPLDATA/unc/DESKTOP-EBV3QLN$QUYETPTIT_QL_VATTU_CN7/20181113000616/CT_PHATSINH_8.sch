drop Table [dbo].[CT_PHATSINH]
go
SET ANSI_PADDING ON
go

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PHATSINH](
	[PHIEU] [char](8) NOT NULL,
	[MAVT] [char](4) NOT NULL,
	[SOLUONG] [int] NOT NULL,
	[DONGIA] [float] NOT NULL,
	[trigia]  AS ([soluong]*[dongia]),
	[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL
)

GO
ALTER TABLE [dbo].[CT_PHATSINH] ADD  CONSTRAINT [MSmerge_df_rowguid_A617E26F92914FB880DB10B0AB249FAC]  DEFAULT (newsequentialid()) FOR [rowguid]
GO
SET ANSI_NULLS ON

go

SET QUOTED_IDENTIFIER ON

go

SET ANSI_PADDING ON

GO
ALTER TABLE [dbo].[CT_PHATSINH] ADD  CONSTRAINT [PK_CT_PHATSINH] PRIMARY KEY CLUSTERED 
(
	[PHIEU] ASC,
	[MAVT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO
