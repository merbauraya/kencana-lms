package com.kencana.lms.asset;


import com.kencana.lms.model.CatalogItem;
import com.kencana.lms.service.CatalogItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class CatalogItemAssetRendererFactory extends BaseAssetRendererFactory {
	

    public static final String CLASS_NAME = CatalogItem.class.getName();

    public static final String TYPE = "kencana";

    @Override
    public AssetRenderer getAssetRenderer(long classPK, int type)
            throws PortalException, SystemException {

    	CatalogItem catalogItem = CatalogItemLocalServiceUtil.getCatalogItem(classPK);
        
        CatalogItemAssetRenderer catalogItemAssetRender =
    			new CatalogItemAssetRenderer(catalogItem);
        catalogItemAssetRender.setAssetRendererType(type);
        
        return catalogItemAssetRender;
    }
    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {

           return themeDisplay.getURLPortal()
                            + "/kencana-portlet/catalog_item.png";

    }
    @Override
    public String getClassName() {
            return CLASS_NAME;
    }

    @Override
    public String getType() {
            return TYPE;
    }

    @Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

            return true;//SuburItemPermission.contains(permissionChecker, classPK, actionId);
    }

    @Override
    public boolean isLinkable() {
            return _LINKABLE;
    }

    private static final boolean _LINKABLE = true;
    
    private static final Log LOGGER = LogFactoryUtil.getLog(CatalogItemAssetRendererFactory.class);
}
