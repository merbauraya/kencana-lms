create table Catalog (
	catalogId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createdByUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	publisher VARCHAR(75) null,
	isbn VARCHAR(75) null,
	issn VARCHAR(75) null,
	callNumber VARCHAR(75) null,
	catalogAbstract VARCHAR(75) null,
	templateId LONG,
	visible BOOLEAN,
	marc VARCHAR(75) null
);

create table CatalogItem (
	CatalogItemId LONG not null primary key,
	catalogId LONG,
	barcode VARCHAR(75) null,
	callNumber VARCHAR(75) null,
	holdingLibraryId LONG,
	lastCheckOutDate DATE null,
	lastSeenDate DATE null,
	acquiredDate DATE null,
	withdrawnDate DATE null,
	lostDate DATE null,
	circulationCount INTEGER,
	renewalCount INTEGER,
	reservedCount INTEGER,
	checkedOutDate DATE null,
	publicNote VARCHAR(75) null,
	privateNote VARCHAR(75) null,
	purchasePrice DOUBLE,
	replacementPrice DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table CatalogTemplate (
	templateId LONG not null primary key,
	templateName VARCHAR(75) null,
	description VARCHAR(75) null,
	active_ BOOLEAN,
	createBy LONG,
	createdDate DATE null
);

create table CatalogTemplateSubfield (
	catalogTemplateSubfieldId LONG not null primary key,
	catalogTemplateTagId LONG,
	subfield VARCHAR(75) null,
	repeatable BOOLEAN,
	mandatory BOOLEAN,
	isURL BOOLEAN
);

create table CatalogTemplateTag (
	catelogTemplateTagId LONG not null primary key,
	catelogTemplateId LONG,
	tag VARCHAR(75) null,
	repeatable BOOLEAN,
	mandatory BOOLEAN,
	helpText VARCHAR(75) null
);

create table Kencana_Catalog (
	catalogId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createdByUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	itemTypeId LONG,
	title TEXT null,
	author TEXT null,
	publisher VARCHAR(75) null,
	isbn VARCHAR(75) null,
	issn VARCHAR(75) null,
	callNumber VARCHAR(75) null,
	UUID VARCHAR(75) null,
	catalogAbstract TEXT null,
	templateId LONG,
	visible BOOLEAN,
	coverImageId LONG,
	marc TEXT null,
	workflowStatus INTEGER
);

create table Kencana_CatalogItem (
	catalogItemId LONG not null primary key,
	catalogId LONG,
	catalogTitle VARCHAR(75) null,
	callNumber VARCHAR(75) null,
	holdingLibraryId LONG,
	currentLibraryId LONG,
	barcode VARCHAR(75) null,
	copyNumber INTEGER,
	locationId LONG,
	itemCategoryId LONG,
	itemTypeId LONG,
	withdrawnStatus BOOLEAN,
	lostStatus BOOLEAN,
	damageStatus BOOLEAN,
	notForLoanStatus BOOLEAN,
	lastSeenDate DATE null,
	withdrawnDate DATE null,
	lostDate DATE null,
	lastCheckOutDate DATE null,
	circulationCount INTEGER,
	renewalCount INTEGER,
	reservedCount INTEGER,
	checkedOutDate DATE null,
	reservedBy LONG,
	claimCount DOUBLE,
	dueDate DATE null,
	checkOutBy LONG,
	released BOOLEAN,
	releaseDate DATE null,
	releaseByUserId LONG,
	vendorId LONG,
	invoiceId LONG,
	purchasePrice DOUBLE,
	replacementPrice DOUBLE,
	currencyId LONG,
	localPurchasePrice DOUBLE,
	publicNote TEXT null,
	privateNote TEXT null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	acquiredDate DATE null,
	workflowStatus INTEGER
);

create table Kencana_CatalogTemplate (
	templateId LONG not null primary key,
	templateName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	description VARCHAR(75) null,
	active_ BOOLEAN,
	createBy LONG,
	createdDate DATE null
);

create table Kencana_CatalogTemplateSubfield (
	catalogTemplateSubfieldId LONG not null primary key,
	catalogTemplateTagId LONG,
	subfield VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	repeatable BOOLEAN,
	mandatory BOOLEAN,
	isURL BOOLEAN
);

create table Kencana_CatalogTemplateTag (
	catelogTemplateTagId LONG not null primary key,
	catelogTemplateId LONG,
	groupId LONG,
	companyId LONG,
	tag VARCHAR(75) null,
	repeatable BOOLEAN,
	mandatory BOOLEAN,
	helpText VARCHAR(75) null
);

create table Kencana_CircTransHistory (
	transId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	libraryId LONG,
	patronId LONG,
	catalogItemId LONG,
	transDate DATE null,
	dueDate DATE null,
	overdue BOOLEAN,
	returnDate DATE null,
	lastRenewDate DATE null,
	renewCount INTEGER,
	fineAmount DOUBLE
);

create table Kencana_CirculationRule (
	circulationRuleId LONG not null primary key,
	libraryId LONG,
	companyId LONG,
	groupId LONG,
	patronCategoryId LONG,
	itemTypeId LONG,
	itemCategoryId LONG,
	maxCheckoutAllowed INTEGER,
	renewalCountAllowed INTEGER,
	reservedCountAllowed INTEGER,
	periodUnit INTEGER,
	loanPeriod INTEGER,
	loanPeriodIfReserved INTEGER,
	rentalCharge DOUBLE,
	finePerPeriod DOUBLE,
	fineGracePeriod INTEGER,
	maxFineAmount DOUBLE,
	userId LONG,
	createdDate DATE null
);

create table Kencana_CirculationTrans (
	transId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	libraryId LONG,
	patronId LONG,
	catalogItemId LONG,
	transDate DATE null,
	dueDate DATE null,
	overdue BOOLEAN,
	returnDate DATE null,
	lastRenewDate DATE null,
	renewCount INTEGER
);

create table Kencana_ItemCategory (
	itemCategoryId LONG not null primary key,
	itemCategoryName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	userId LONG,
	modifiedDate DATE null
);

create table Kencana_ItemType (
	itemTypeId LONG not null primary key,
	itemTypeName VARCHAR(75) null,
	notForLoan BOOLEAN,
	coverId LONG,
	checkoutMessage VARCHAR(75) null,
	checkinMessage VARCHAR(75) null,
	rentalRate DOUBLE,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null
);

create table Kencana_Library (
	libraryId LONG not null primary key,
	libraryName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	address3 VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	website STRING null,
	notes TEXT null
);

create table Kencana_Location (
	locationId LONG not null primary key,
	libraryId LONG,
	companyId LONG,
	groupId LONG,
	locationName VARCHAR(75) null
);

create table Kencana_MarcBatchUpload (
	marcBatchUploadId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createBy LONG,
	createdDate DATE null,
	processed BOOLEAN,
	importDate DATE null,
	importByUserId LONG,
	partialImport BOOLEAN,
	fileCount INTEGER,
	description VARCHAR(75) null,
	recordCount INTEGER
);

create table Kencana_MarcBatchUploadItem (
	marcBatchUploadItemId LONG not null primary key,
	marcBatchUploadId LONG,
	groupId LONG,
	companyId LONG,
	createdBy LONG,
	createdDate DATE null,
	processed BOOLEAN,
	importDate DATE null,
	importByUserId LONG,
	marcContent VARCHAR(75) null,
	fileName VARCHAR(75) null,
	fileEntryId LONG
);

create table Kencana_MarcSubfield (
	MarcSubfieldId LONG not null primary key,
	tag VARCHAR(75) null,
	tagType VARCHAR(75) null,
	subfield VARCHAR(75) null,
	description VARCHAR(75) null,
	repetable BOOLEAN,
	mandatory BOOLEAN,
	authorisedValue VARCHAR(75) null,
	authTypeCode VARCHAR(75) null,
	isURL BOOLEAN,
	helpText VARCHAR(75) null
);

create table Kencana_MarcTag (
	tagId LONG not null primary key,
	tag VARCHAR(75) null,
	description VARCHAR(75) null,
	helpText VARCHAR(75) null,
	repetable BOOLEAN,
	defaultValue VARCHAR(75) null,
	indicator1 BOOLEAN,
	indicator2 BOOLEAN,
	tagType VARCHAR(75) null
);

create table Kencana_Patron (
	patronId LONG not null primary key,
	cardNumber VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	libraryId LONG,
	expiryDate DATE null,
	patronCategoryId LONG,
	patronStatusId LONG,
	patronNote STRING null
);

create table Kencana_PatronCategory (
	patronCategoryId LONG not null primary key,
	patronCategoryName VARCHAR(75) null,
	notes STRING null,
	groupId LONG,
	companyId LONG
);

create table Kencana_PatronStatus (
	patronStatusId LONG not null primary key,
	patronStatusName VARCHAR(75) null,
	noLogin BOOLEAN,
	noCheckout BOOLEAN,
	noReserve BOOLEAN,
	noRenew BOOLEAN,
	color INTEGER,
	groupId LONG,
	companyId LONG
);

create table Kencana_ReasonCode (
	reasonCodeId LONG not null primary key,
	reasonCodeName VARCHAR(75) null,
	groupId LONG,
	companyId LONG
);

create table Kencana_Vendor (
	vendorId LONG not null primary key,
	vendorCode VARCHAR(75) null,
	vendorName VARCHAR(75) null,
	email VARCHAR(75) null,
	url STRING null,
	companyId LONG,
	groupId LONG,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	address3 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	contactPerson VARCHAR(75) null,
	phone VARCHAR(75) null,
	fax VARCHAR(75) null,
	isPublisher BOOLEAN,
	isBinder BOOLEAN,
	isActive BOOLEAN,
	rating VARCHAR(75) null,
	bankName VARCHAR(75) null,
	bankAccount VARCHAR(75) null,
	lastOrderDate DATE null,
	note STRING null
);

create table Library (
	libraryId LONG not null primary key,
	libraryName VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	address3 VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	phone VARCHAR(75) null,
	email VARCHAR(75) null,
	website VARCHAR(75) null,
	notes VARCHAR(75) null
);

create table MarcSubfield (
	MarcSubfieldId LONG not null primary key,
	tag VARCHAR(75) null,
	tagType VARCHAR(75) null,
	subfield VARCHAR(75) null,
	description VARCHAR(75) null,
	repetable BOOLEAN,
	mandatory BOOLEAN,
	authorisedValue VARCHAR(75) null,
	authTypeCode VARCHAR(75) null,
	isURL BOOLEAN,
	helpText VARCHAR(75) null
);

create table MarcTag (
	tagId LONG not null primary key,
	tag VARCHAR(75) null,
	description VARCHAR(75) null,
	helpText VARCHAR(75) null,
	repetable BOOLEAN,
	defaultValue VARCHAR(75) null,
	indicator1 BOOLEAN,
	indicator2 BOOLEAN,
	tagType VARCHAR(75) null
);