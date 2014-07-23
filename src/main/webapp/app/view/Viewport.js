Ext.require('Westar.view.MenuView');
Ext.require('Westar.view.TabView');
Ext.define('Westar.view.Viewport', {
	extend: 'Ext.container.Viewport',
	layout: {
		type: 'border',
		padding: 3
	},
	defaults: {
		split: true
	},
	initComponent: function() {
		this.items = [{
			region: 'west',
            layout: 'absolute',
            title: '菜单',
            collapsible: true,
            split: true,
            width: 250,
            stateId: 'westRegion',
            stateful: true,
            items: {
            	xtype: 'menuView',
            	layout: 'fit',
            	anchor:'100% 100%'
            }
		}, {
			region: 'center',
			layout: 'fit',
            items: {
            	xtype: 'tabView',
            	items: [{
                    title: 'Foo',
                    closable: true,
                    html: '1312321'
                }, {
                    title: 'Bar',
                    closable: true,
                    tabConfig: {
                        title: 'Custom Title',
                        tooltip: 'A button tooltip'
                    }
                }]
            }
		}, {
			region: 'east',
            collapsible: true,
            floatable: true,
            split: true,
            width: 200,
            minWidth: 120,
            minHeight: 140,
            title: 'East',
            layout: {
                type: 'vbox',
                padding: 5,
                align: 'stretch'
            },
            items: []
		}];
		this.callParent();
	}
});