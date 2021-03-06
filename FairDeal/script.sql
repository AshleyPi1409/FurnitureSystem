USE [master]
GO
/****** Object:  Database [FairDeal]    Script Date: 10/14/2015 9:51:02 PM ******/
CREATE DATABASE [FairDeal]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FairDeal', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\FairDeal.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'FairDeal_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\FairDeal_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [FairDeal] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FairDeal].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FairDeal] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FairDeal] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FairDeal] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FairDeal] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FairDeal] SET ARITHABORT OFF 
GO
ALTER DATABASE [FairDeal] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FairDeal] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [FairDeal] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FairDeal] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FairDeal] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FairDeal] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FairDeal] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FairDeal] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FairDeal] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FairDeal] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FairDeal] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FairDeal] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FairDeal] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FairDeal] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FairDeal] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FairDeal] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FairDeal] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FairDeal] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FairDeal] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FairDeal] SET  MULTI_USER 
GO
ALTER DATABASE [FairDeal] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FairDeal] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FairDeal] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FairDeal] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [FairDeal]
GO
/****** Object:  Table [dbo].[Action]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Action](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Action] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customer](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerName] [nvarchar](50) NULL,
	[ContactNo] [varchar](20) NULL,
	[Address] [nvarchar](200) NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Diary]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diary](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AccountID] [int] NULL,
	[Time] [datetime] NULL,
	[Description] [nvarchar](200) NULL,
 CONSTRAINT [PK_Diary] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Employee]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Address] [nvarchar](200) NULL,
	[ContactNo] [varchar](20) NULL,
	[Username] [varchar](55) NULL,
	[Password] [varchar](50) NULL,
	[Department] [nvarchar](100) NULL,
	[RoleID] [int] NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Order]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[OrderDate] [datetime] NULL,
	[SellerID] [int] NOT NULL,
	[CustomerID] [int] NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderLine]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderLine](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NULL,
	[Price] [decimal](18, 0) NULL,
 CONSTRAINT [PK_OrderLine] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](200) NULL,
	[UnitPrice] [decimal](18, 0) NULL,
	[Quantity] [int] NULL,
	[CategoryID] [int] NULL,
	[ImportPrice] [decimal](18, 0) NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[IsActive] [bit] NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role_Action]    Script Date: 10/14/2015 9:51:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role_Action](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[RoleID] [int] NOT NULL,
	[ActionID] [int] NOT NULL,
 CONSTRAINT [PK_Role_Action] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Action] ON 

INSERT [dbo].[Action] ([ID], [Name], [IsActive]) VALUES (1, N'Sell products', 1)
INSERT [dbo].[Action] ([ID], [Name], [IsActive]) VALUES (2, N'Create account', 1)
INSERT [dbo].[Action] ([ID], [Name], [IsActive]) VALUES (3, N'Create category', 1)
SET IDENTITY_INSERT [dbo].[Action] OFF
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([ID], [Name], [IsActive]) VALUES (1, N'Table', 1)
INSERT [dbo].[Category] ([ID], [Name], [IsActive]) VALUES (2, N'School', 1)
INSERT [dbo].[Category] ([ID], [Name], [IsActive]) VALUES (3, N'Kitchen', 1)
INSERT [dbo].[Category] ([ID], [Name], [IsActive]) VALUES (4, N'Living room', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([ID], [CustomerName], [ContactNo], [Address], [IsActive]) VALUES (1, N'Mai phuong thuy', NULL, NULL, 1)
INSERT [dbo].[Customer] ([ID], [CustomerName], [ContactNo], [Address], [IsActive]) VALUES (2, N'Mai phuong thuy 2', N'adasd', N'444', 1)
INSERT [dbo].[Customer] ([ID], [CustomerName], [ContactNo], [Address], [IsActive]) VALUES (3, N'Mai phuong thuy 3', N'adasd', N'444', 1)
SET IDENTITY_INSERT [dbo].[Customer] OFF
SET IDENTITY_INSERT [dbo].[Employee] ON 

INSERT [dbo].[Employee] ([ID], [Name], [Address], [ContactNo], [Username], [Password], [Department], [RoleID], [IsActive]) VALUES (2, N'Nguyen van a', N'hue', N'0102303240', N'a', N'asdpdspsa', N'eodfos', 2, 1)
SET IDENTITY_INSERT [dbo].[Employee] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [ProductName], [UnitPrice], [Quantity], [CategoryID], [ImportPrice], [IsActive]) VALUES (1, N'Tennis table', CAST(150000 AS Decimal(18, 0)), 4, 1, CAST(140000 AS Decimal(18, 0)), 1)
INSERT [dbo].[Product] ([ID], [ProductName], [UnitPrice], [Quantity], [CategoryID], [ImportPrice], [IsActive]) VALUES (2, N'Knife', CAST(1000 AS Decimal(18, 0)), 120, 2, CAST(400 AS Decimal(18, 0)), 1)
INSERT [dbo].[Product] ([ID], [ProductName], [UnitPrice], [Quantity], [CategoryID], [ImportPrice], [IsActive]) VALUES (3, N'Light', CAST(80000 AS Decimal(18, 0)), 24, 3, CAST(7000 AS Decimal(18, 0)), 1)
INSERT [dbo].[Product] ([ID], [ProductName], [UnitPrice], [Quantity], [CategoryID], [ImportPrice], [IsActive]) VALUES (4, N'Vase', CAST(6000 AS Decimal(18, 0)), 45, 4, CAST(5000 AS Decimal(18, 0)), 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([ID], [Name], [IsActive]) VALUES (1, N'Role1', 1)
INSERT [dbo].[Role] ([ID], [Name], [IsActive]) VALUES (2, N'Administrator', 1)
INSERT [dbo].[Role] ([ID], [Name], [IsActive]) VALUES (3, N'Seller', 1)
INSERT [dbo].[Role] ([ID], [Name], [IsActive]) VALUES (4, N'Keeper', 1)
SET IDENTITY_INSERT [dbo].[Role] OFF
SET IDENTITY_INSERT [dbo].[Role_Action] ON 

INSERT [dbo].[Role_Action] ([ID], [RoleID], [ActionID]) VALUES (1, 1, 1)
INSERT [dbo].[Role_Action] ([ID], [RoleID], [ActionID]) VALUES (2, 2, 1)
INSERT [dbo].[Role_Action] ([ID], [RoleID], [ActionID]) VALUES (3, 2, 2)
INSERT [dbo].[Role_Action] ([ID], [RoleID], [ActionID]) VALUES (4, 2, 3)
INSERT [dbo].[Role_Action] ([ID], [RoleID], [ActionID]) VALUES (5, 3, 2)
SET IDENTITY_INSERT [dbo].[Role_Action] OFF
ALTER TABLE [dbo].[Diary]  WITH CHECK ADD  CONSTRAINT [FK_Diary_Employee] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Employee] ([ID])
GO
ALTER TABLE [dbo].[Diary] CHECK CONSTRAINT [FK_Diary_Employee]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([ID])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Role]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Customer] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([ID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Customer]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Employee] FOREIGN KEY([SellerID])
REFERENCES [dbo].[Employee] ([ID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Employee]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD  CONSTRAINT [FK_OrderLine_Order] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Order] ([ID])
GO
ALTER TABLE [dbo].[OrderLine] CHECK CONSTRAINT [FK_OrderLine_Order]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD  CONSTRAINT [FK_OrderLine_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ID])
GO
ALTER TABLE [dbo].[OrderLine] CHECK CONSTRAINT [FK_OrderLine_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Role_Action]  WITH CHECK ADD  CONSTRAINT [FK_Role_Action_Action] FOREIGN KEY([ActionID])
REFERENCES [dbo].[Action] ([ID])
GO
ALTER TABLE [dbo].[Role_Action] CHECK CONSTRAINT [FK_Role_Action_Action]
GO
ALTER TABLE [dbo].[Role_Action]  WITH CHECK ADD  CONSTRAINT [FK_Role_Action_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([ID])
GO
ALTER TABLE [dbo].[Role_Action] CHECK CONSTRAINT [FK_Role_Action_Role]
GO
USE [master]
GO
ALTER DATABASE [FairDeal] SET  READ_WRITE 
GO
