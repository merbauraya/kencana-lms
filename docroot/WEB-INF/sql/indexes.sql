create index IX_6F368 on Catalog (templateId);

create index IX_65377312 on CatalogItem (catalogId);

create index IX_7B656189 on CatalogTemplateSubfield (catalogTemplateTagId);

create index IX_6E6607AD on CatalogTemplateTag (catelogTemplateId);

create index IX_2CB89E83 on Kencana_Catalog (companyId);
create index IX_A5CCE9C5 on Kencana_Catalog (groupId);
create index IX_7B65BD43 on Kencana_Catalog (groupId, companyId);
create index IX_2935A98A on Kencana_Catalog (groupId, workflowStatus);
create index IX_137C8861 on Kencana_Catalog (itemTypeId);
create index IX_DC2B096E on Kencana_Catalog (templateId);

create unique index IX_ABD61738 on Kencana_CatalogItem (barcode);
create index IX_7096574C on Kencana_CatalogItem (catalogId);
create unique index IX_1A5E7C00 on Kencana_CatalogItem (companyId, barcode);
create index IX_65AEF8FA on Kencana_CatalogItem (companyId, groupId);
create index IX_A138216B on Kencana_CatalogItem (companyId, groupId, released);
create index IX_F9749DAC on Kencana_CatalogItem (companyId, groupId, withdrawnStatus);
create index IX_9218F15F on Kencana_CatalogItem (holdingLibraryId);

create index IX_1E05C0F on Kencana_CatalogTemplateSubfield (catalogTemplateTagId);

create index IX_7FEEE833 on Kencana_CatalogTemplateTag (catelogTemplateId);

create index IX_784C1772 on Kencana_CircTransHistory (companyId, catalogItemId);
create index IX_61E65065 on Kencana_CircTransHistory (companyId, groupId);
create index IX_F68E8BE1 on Kencana_CircTransHistory (companyId, groupId, libraryId);
create index IX_1E9A862 on Kencana_CircTransHistory (companyId, patronId);

create index IX_DC6B1B79 on Kencana_CirculationRule (companyId);
create index IX_C41F3151 on Kencana_CirculationRule (companyId, groupId);
create index IX_AF8C9829 on Kencana_CirculationRule (companyId, libraryId, itemTypeId);
create index IX_910291E8 on Kencana_CirculationRule (companyId, libraryId, patronCategoryId);
create index IX_F656CD44 on Kencana_CirculationRule (companyId, libraryId, patronCategoryId, itemTypeId);
create unique index IX_1EA92810 on Kencana_CirculationRule (companyId, patronCategoryId, itemTypeId, itemCategoryId);

create unique index IX_586FE410 on Kencana_CirculationTrans (companyId, catalogItemId);
create index IX_E98F6B83 on Kencana_CirculationTrans (companyId, groupId);
create index IX_DE87F203 on Kencana_CirculationTrans (companyId, groupId, libraryId);
create index IX_17843CB1 on Kencana_CirculationTrans (companyId, libraryId, overdue);
create index IX_6F63F104 on Kencana_CirculationTrans (companyId, patronId);
create index IX_D89D37FE on Kencana_CirculationTrans (patronId);

create index IX_813F5093 on Kencana_ItemCategory (companyId, groupId);
create index IX_52410239 on Kencana_ItemCategory (groupId);

create index IX_AE557C4F on Kencana_ItemType (companyId, groupId);

create index IX_85A7F121 on Kencana_Library (companyId);
create index IX_29B438A9 on Kencana_Library (companyId, groupId);

create index IX_E83F9917 on Kencana_Location (companyId, groupId);
create index IX_1E65631 on Kencana_Location (libraryId);

create index IX_493B5984 on Kencana_MarcBatchUpload (companyId, groupId);
create index IX_2C5125E8 on Kencana_MarcBatchUpload (groupId);
create index IX_E62DF23E on Kencana_MarcBatchUpload (groupId, companyId, processed);
create index IX_4D8AB13C on Kencana_MarcBatchUpload (processed);

create index IX_AD6E4F6C on Kencana_MarcBatchUploadItem (marcBatchUploadId);
create index IX_5AB26C92 on Kencana_MarcBatchUploadItem (marcBatchUploadId, processed);

create unique index IX_29D79F47 on Kencana_MarcSubfield (tag, tagType, subfield);

create unique index IX_E012165B on Kencana_MarcTag (tag, tagType);
create index IX_CEB20943 on Kencana_MarcTag (tagType);

create unique index IX_FB6C809B on Kencana_Patron (cardNumber);
create index IX_9ACD844B on Kencana_Patron (companyId, groupId, patronCategoryId);
create index IX_53A0253F on Kencana_Patron (companyId, groupId, patronStatusId);
create index IX_4D0BB0AC on Kencana_Patron (companyId, libraryId);
create index IX_FC6D5B8 on Kencana_Patron (libraryId);
create index IX_61505128 on Kencana_Patron (userId);

create index IX_A8E9041C on Kencana_PatronCategory (companyId);
create index IX_CD89500E on Kencana_PatronCategory (companyId, groupId);
create index IX_E9DBE19E on Kencana_PatronCategory (groupId);

create index IX_A496EBA8 on Kencana_PatronStatus (companyId);
create index IX_81B92602 on Kencana_PatronStatus (companyId, groupId);
create index IX_B2B63C2A on Kencana_PatronStatus (groupId);

create index IX_BE870033 on Kencana_ReasonCode (companyId, groupId);
create index IX_80EAD699 on Kencana_ReasonCode (groupId);

create index IX_4797DFC0 on Kencana_Vendor (companyId);
create index IX_70017167 on Kencana_Vendor (companyId, vendorName);

create unique index IX_94A1A88D on MarcSubfield (tag, tagType, subfield);

create unique index IX_7C9B69D5 on MarcTag (tag, tagType);
create index IX_AA2CF189 on MarcTag (tagType);