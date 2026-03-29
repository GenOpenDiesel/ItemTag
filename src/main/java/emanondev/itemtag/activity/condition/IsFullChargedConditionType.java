package emanondev.itemtag.activity.condition;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IsFullChargedConditionType extends BooleanValueConditionType {

    public IsFullChargedConditionType() {
        super("is_full_charged", EntityDamageByEntityEvent.class);
    }

    @Override
    protected boolean getCurrentValue(@NotNull Player player, @NotNull ItemStack item, Event event) {
        if (!(event instanceof EntityDamageByEntityEvent evt))
            return false;
        if (!(evt.getDamager() instanceof HumanEntity human))
            return true;

        return human.getAttackCooldown() == 1;
    }
}
