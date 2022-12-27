package net.bp82125.terrarianboots.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class DiceItem extends Item {
    public DiceItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, user, hand);
    }

    private int getRandomNumber(){
        return Random.createLocal().nextBetween(1,6);
    }

    private void outputRandomNumber(PlayerEntity player){
        int stack_count = player.getStackInHand(Hand.MAIN_HAND).getCount();
        int sum = 0;
        for(int i = 0;i<stack_count;++i){
            sum += getRandomNumber();
        }
        player.sendMessage(Text.literal("Your lucky number is: " + sum));
    }
}
